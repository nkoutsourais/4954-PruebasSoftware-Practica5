package damas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
  damas.controllers.AllTest.class, 
  damas.models.AllTest.class, 
})
public class AllTest {

}