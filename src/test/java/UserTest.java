import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.eoh.invetory.management.entity.Asset;
import za.co.eoh.invetory.management.entity.Role;
import za.co.eoh.invetory.management.entity.User;
import za.co.eoh.invetory.management.entity.UserAsset;
import za.co.eoh.invetory.management.service.AssetService;
import za.co.eoh.invetory.management.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ContextConfiguration("classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

  @Autowired
  private UserService userService;

  @Autowired
  private AssetService assetService;


  @Before
  public void setupTest() {
    //  dataSourceInitializer().afterPropertiesSet();
  }

  @After
  public void afterTest() {
    //dataSourceInitializer().destroy();
  }

  @Test
@Ignore
  public void testFindAllUsers() {
    List<User> users = userService.getAllUser();
    Assert.assertNotNull(users);
    Assert.assertFalse(users.isEmpty());
    System.out.println(users.size());
  }

  @Test
  @Ignore
  public void testFindUserByID() {
    User user = userService.getUserById(2);
    Assert.assertNotNull(user);
    Assert.assertNotNull(user.getUserRole());
    System.out.println(user);
  }

  @Test
  @Ignore
  public void testAddUser() {
    User user = new User();
    user.setUsername("uname");
    user.setPassword("password");

    Role userRole = new Role(2);
    user.setUserRole(userRole);

    List<UserAsset> userAssetList = new ArrayList<>();


    UserAsset userAsset = new UserAsset();

    Asset asset=assetService.getAssetById(32);
    userAsset.setAsset(asset);

    UserAsset userAsset1 = new UserAsset();
    Asset asset1=assetService.getAssetById(34);
    userAsset1.setAsset(asset1);

    userAsset.setUser(user);
    userAsset1.setUser(user);

    userAssetList.addAll(Arrays.asList(userAsset, userAsset1));

    user.setAssignedAssets(userAssetList);


    try {
      userService.mergeUser(user);
      System.out.println(user);
    } catch (Exception ex) {
      Assert.fail("failed to add user: " + ex.getMessage());
      ex.printStackTrace();
    }
  }
  @Test
  @Ignore
  public void testAssignUserAsset()
  {
    User user = userService.getUserById(47);
    List<UserAsset> userAssetList = user.getAssignedAssets();


    UserAsset userAsset = new UserAsset();

    Asset asset=assetService.getAssetById(34);
    userAsset.setAsset(asset);
    userAsset.setUser(user);

    userAssetList.addAll(Arrays.asList(userAsset));

    user.setAssignedAssets(userAssetList);

    try {
      userService.mergeUser(user);
      System.out.println(user);
    } catch (Exception ex) {
      Assert.fail("failed to assign user asset: " + ex.getMessage());
      ex.printStackTrace();
    }
  }


@Test
@Ignore
public void testUnAssignUserAsset()
{
  User user = userService.getUserById(47);
  List<UserAsset> userAssetList = user.getAssignedAssets();


  UserAsset userAsset = user.getAssignedAssets().get(1);
  System.out.println("asset to remove="+userAsset.getAssetID());
  userAssetList.remove(userAsset);

  try {
    userService.saveOrUpdate(user);
    System.out.println(user);
  } catch (Exception ex) {
    Assert.fail("failed to assign user asset: " + ex.getMessage());
    ex.printStackTrace();
  }
}

  @Test
  @Ignore
  public void testDeleteUser()
  {
    User user = userService.getUserById(47);
    try {
      userService.deleteUser(user);
      System.out.println(user);
    } catch (Exception ex) {
      Assert.fail("failed to delete user : " + ex.getMessage());
      ex.printStackTrace();
    }
  }


}
