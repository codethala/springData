package com.dan.sample;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbConfigurationBuilder.mongoDb;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=App.class)
public class NoSqlSpringDataManaged {

    @Rule
    public MongoDbRule remoteMongoDbRule = new MongoDbRule(mongoDb().databaseName("nosqlunit").build());    
    
    @Autowired
    private ModelRepository repo;
    
    @Test
    @UsingDataSet(locations="model-dataset.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
    public void canFindAll() {
        List<Model> allModels = repo.findAll();
        Assert.assertTrue("should find 2 models", allModels.size() == 2);
    }
    
    @Test
    @UsingDataSet(locations="model-dataset.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
    public void canFindByAStringProp() {
        List<Model> foundByString = repo.findByaStringProp("Test");
        Assert.assertTrue("should find a model by string", foundByString.size() == 1);
    }
    
    @Test
    @UsingDataSet(locations="model-dataset.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
    public void canFindByAnIntProp() {
        List<Model> foundByInt = repo.findByanIntProp(1);
        Assert.assertTrue("should find a model by int", foundByInt.size() == 1);
    }


    @Test
    @UsingDataSet(locations="model-dataset.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
    public void canFindBySpringFindOne() {
        Model found = repo.findOne("a");
        Assert.assertTrue("should find a model by id using findOne", found != null);
    }
    
}
