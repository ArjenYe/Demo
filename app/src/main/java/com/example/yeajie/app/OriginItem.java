package com.example.yeajie.app;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.example.yeajie.app.original.animation.ImageAnimationActivity;
import com.example.yeajie.app.original.animation.JsonAnimationActivity;
import com.example.yeajie.app.original.animation.ShakeAnimationActivity;
import com.example.yeajie.app.original.autocall.AutoDialActivity;
import com.example.yeajie.app.original.autocall.contactlist.ContactListActivity;
import com.example.yeajie.app.original.autocall1.ContactVersionOneActivity;
import com.example.yeajie.app.original.autosearch.AutoSearchActivity;
import com.example.yeajie.app.original.bezier.BezierActivity;
import com.example.yeajie.app.original.bezier.draw.DrawBoardActivity;
import com.example.yeajie.app.original.bezier.wave.WaveActivity;
import com.example.yeajie.app.original.camera.CameraActivity;
import com.example.yeajie.app.original.checkbox.CheckBoxActivity;
import com.example.yeajie.app.original.clock.ShowTimeActivity;
import com.example.yeajie.app.original.configuration.ConfigurationActivity;
import com.example.yeajie.app.original.contacts.MyContactsActivity;
import com.example.yeajie.app.original.coordinator.CoordinatorBehaviorActivity;
import com.example.yeajie.app.original.coordinator.toolbar.HideToolbarActivity;
import com.example.yeajie.app.original.custom.CustomViewActivity;
import com.example.yeajie.app.original.dialog.DialogFragmentActivity;
import com.example.yeajie.app.original.drawermenu.DrawerMenuActivity;
import com.example.yeajie.app.original.firebase.MainActivity;
import com.example.yeajie.app.original.flipper.FlipperActivity;
import com.example.yeajie.app.original.gesture.GestureActivity;
import com.example.yeajie.app.original.http.HttpRequestActivity;
import com.example.yeajie.app.original.mediarecorder.MediaRecorderActivity;
import com.example.yeajie.app.original.mytextview.MyTextViewActivity;
import com.example.yeajie.app.original.opengl.OpenGlActivity;
import com.example.yeajie.app.original.picture.PictureActivity;
import com.example.yeajie.app.original.popupwindow.PopupWindowActivity;
import com.example.yeajie.app.original.progressbar.MyProgressBarActivity;
import com.example.yeajie.app.original.realtimedatabase.RealTimeDatabaseActivity;
import com.example.yeajie.app.original.recyclerview.expand.ExpandRecyclerActivity;
import com.example.yeajie.app.original.recyclerview.fetch.FetchRecyclerActivity;
import com.example.yeajie.app.original.rxbinding.RxBindingActivity;
import com.example.yeajie.app.original.selector.SelectorActivity;
import com.example.yeajie.app.original.sensor.LightSensorActivity;
import com.example.yeajie.app.original.sensor.OrientationSensorActivity;
import com.example.yeajie.app.original.sensor.ShowAllSensorActivity;
import com.example.yeajie.app.original.speechtotext.SpeechToTextActivity;
import com.example.yeajie.app.original.timecountdown.CountDownTimeActivity;
import com.example.yeajie.app.original.timepick.TimePickActivity;
import com.example.yeajie.app.original.vibrator.VibratorActivity;
import com.example.yeajie.app.original.wallpaper.WallPaperActivity;
import com.example.yeajie.app.original.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arjen
 */

final class OriginItem extends HomeItem {

    private OriginItem(@DrawableRes int itemImg, @StringRes int itemSummary, Class launcherClass) {
        this.itemImg = itemImg;
        this.itemSummary = itemSummary;
        this.launcherClass = launcherClass;
    }

    static List<HomeItem> getItems() {
        List<HomeItem> homeItems = new ArrayList<>();
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_wave, WaveActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_draw_board, DrawBoardActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_bezier, BezierActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_media_recorder, MediaRecorderActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_time_pick, TimePickActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_configuration, ConfigurationActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_gesture, GestureActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_wall_paper, WallPaperActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_web_view, WebViewActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_view_flipper, FlipperActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_light_sensor, LightSensorActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_vibrator, VibratorActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_orientation_sensor, OrientationSensorActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_show_all_sensor, ShowAllSensorActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_drawer_menu, DrawerMenuActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_show_time, ShowTimeActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_hide_toolbar, HideToolbarActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_popup_window, PopupWindowActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_coordinator_behavior, CoordinatorBehaviorActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_custom_view, CustomViewActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_shake_animation, ShakeAnimationActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_count_down_time, CountDownTimeActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_auto_search, AutoSearchActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_color_selector, SelectorActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_my_progress, MyProgressBarActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_contact_list_version_one, ContactVersionOneActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_contact_list, ContactListActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_check_box, CheckBoxActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_picture, PictureActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_auto_dial, AutoDialActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_camera_enhance_black_24dp, R.string.text_capture, CameraActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_arrow_upward_black_24dp, R.string.text_fetch, FetchRecyclerActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_expand, ExpandRecyclerActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_http_request, HttpRequestActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_animation, JsonAnimationActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_open_gl, OpenGlActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_foot_animation, ImageAnimationActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_my_text_view, MyTextViewActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_my_contacts, MyContactsActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_dialog_fragment, DialogFragmentActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_rx_binding, RxBindingActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_speech_to_text, SpeechToTextActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_real_time_database, RealTimeDatabaseActivity.class));
        homeItems.add(new OriginItem(R.drawable.ic_expand_more_black_24dp, R.string.text_home_page, MainActivity.class));

        return homeItems;
    }
}
