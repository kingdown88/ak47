package appiumtest.utils;

import appiumtest.page.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class UsualClass {

  /**
   * 电话键
   *
   * KEYCODE_CALL 拨号键 5
   *
   * KEYCODE_ENDCALL 挂机键 6
   *
   * KEYCODE_HOME 按键Home 3
   *
   * KEYCODE_MENU 菜单键 82
   *
   * KEYCODE_BACK 返回键 4
   *
   * KEYCODE_SEARCH 搜索键 84
   *
   * KEYCODE_CAMERA 拍照键 27
   *
   * KEYCODE_FOCUS 拍照对焦键 80
   *
   * KEYCODE_POWER 电源键 26
   *
   * KEYCODE_NOTIFICATION 通知键 83
   *
   * KEYCODE_MUTE 话筒静音键 91
   *
   * KEYCODE_VOLUME_MUTE 扬声器静音键 164
   *
   * KEYCODE_VOLUME_UP 音量增加键 24
   *
   * KEYCODE_VOLUME_DOWN 音量减小键 25
   *
   * 控制键
   *
   * KEYCODE_ENTER 回车键 66
   *
   * KEYCODE_ESCAPE ESC键 111
   *
   * KEYCODE_DPAD_CENTER 导航键 确定键 23
   *
   * KEYCODE_DPAD_UP 导航键 向上 19
   *
   * KEYCODE_DPAD_DOWN 导航键 向下 20
   *
   * KEYCODE_DPAD_LEFT 导航键 向左 21
   *
   * KEYCODE_DPAD_RIGHT 导航键 向右 22
   *
   * KEYCODE_MOVE_HOME 光标移动到开始键 122
   *
   * KEYCODE_MOVE_END 光标移动到末尾键 123
   *
   * KEYCODE_PAGE_UP 向上翻页键 92
   *
   * KEYCODE_PAGE_DOWN 向下翻页键 93
   *
   * KEYCODE_DEL 退格键 67
   *
   * KEYCODE_FORWARD_DEL 删除键 112
   *
   * KEYCODE_INSERT 插入键 124
   *
   * KEYCODE_TAB Tab键 61
   *
   * KEYCODE_NUM_LOCK 小键盘锁 143
   *
   * KEYCODE_CAPS_LOCK 大写锁定键 115
   *
   * KEYCODE_BREAK Break/Pause键 121
   *
   * KEYCODE_SCROLL_LOCK 滚动锁定键 116
   *
   * KEYCODE_ZOOM_IN 放大键 168
   *
   * KEYCODE_ZOOM_OUT 缩小键 169
   *
   * 组合键
   *
   * KEYCODE_ALT_LEFT Alt+Left
   *
   * KEYCODE_ALT_RIGHT Alt+Right
   *
   * KEYCODE_CTRL_LEFT Control+Left
   *
   * KEYCODE_CTRL_RIGHT Control+Right
   *
   * KEYCODE_SHIFT_LEFT Shift+Left
   *
   * KEYCODE_SHIFT_RIGHT Shift+Right
   *
   * 基本
   *
   * KEYCODE_0 按键’0’ 7
   *
   * KEYCODE_1 按键’1’ 8
   *
   * KEYCODE_2 按键’2’ 9
   *
   * KEYCODE_3 按键’3’ 10
   *
   * KEYCODE_4 按键’4’ 11
   *
   * KEYCODE_5 按键’5’ 12
   *
   * KEYCODE_6 按键’6’ 13
   *
   * KEYCODE_7 按键’7’ 14
   *
   * KEYCODE_8 按键’8’ 15
   *
   * KEYCODE_9 按键’9’ 16
   *
   * KEYCODE_A 按键’A’ 29
   *
   * KEYCODE_B 按键’B’ 30
   *
   * KEYCODE_C 按键’C’ 31
   *
   * KEYCODE_D 按键’D’ 32
   *
   * KEYCODE_E 按键’E’ 33
   *
   * KEYCODE_F 按键’F’ 34
   *
   * KEYCODE_G 按键’G’ 35
   *
   * KEYCODE_H 按键’H’ 36
   *
   * KEYCODE_I 按键’I’ 37
   *
   * KEYCODE_J 按键’J’ 38
   *
   * KEYCODE_K 按键’K’ 39
   *
   * KEYCODE_L 按键’L’ 40
   *
   * KEYCODE_M 按键’M’ 41
   *
   * KEYCODE_N 按键’N’ 42
   *
   * KEYCODE_O 按键’O’ 43
   *
   * KEYCODE_P 按键’P’ 44
   *
   * KEYCODE_Q 按键’Q’ 45
   *
   * KEYCODE_R 按键’R’ 46
   *
   * KEYCODE_S 按键’S’ 47
   *
   * KEYCODE_T 按键’T’ 48
   *
   * KEYCODE_U 按键’U’ 49
   *
   * KEYCODE_V 按键’V’ 50
   *
   * KEYCODE_W 按键’W’ 51
   *
   * KEYCODE_X 按键’X’ 52
   *
   * KEYCODE_Y 按键’Y’ 53
   *
   * KEYCODE_Z 按键’Z’ 54
   */

  /**
   * 执行删除输入字符
   */
  public static void clearEdit(AndroidDriver dr, String text) {
    int length = text.length();
    for (int i = 0; i < length; i++) {
      dr.pressKeyCode(67);
    }
  }

  /**
   * 返回首页或是执行返回按钮
   */
  public static void back(final AndroidDriver dr) {
    AndroidDriverWait wait = new AndroidDriverWait(dr, 60);
    wait.until(new ExpectedCondition<WebElement>() {
      @Override public WebElement apply(WebDriver d) {
        WebElement button = BasePage.homeLocation(dr, "homepagebutton");
        if (button == null) {
          LogUtil.info("没找到 首页按钮,执行 返回按钮");
          dr.pressKeyCode(4);
          return BasePage.homeLocation(dr, "homepagebutton");
        } else {
          LogUtil.info("返回至 首页页面");
          return button;
        }
      }
    });
  }

  public static void swipe(AndroidDriver<AndroidElement> driver, int x, int y, int toX, int toY,
      int t) {
    TouchAction action =
        new TouchAction(driver).longPress(x, y, Duration.ofMillis(t)).moveTo(toX, toY).release();
    action.perform();
  }

  public static void swipe(AndroidDriver<AndroidElement> driver, int x, int y, int toX, int toY) {
    swipe(driver, x, y, toX, toY, 1000);
  }

  public static void swipeToUp(AndroidDriver<AndroidElement> driver) {
    int width = driver.manage().window().getSize().width;
    int height = driver.manage().window().getSize().height;

    swipe(driver, width / 2, height * 3 / 4, width / 2, height / 4);
    LogUtil.debug(
        "往上滑动：" + width / 2 + "_" + height * 3 / 4 + " to " + width / 2 + "_" + height / 4);
  }
}
