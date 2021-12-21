package  net.fachtnaroe.co2_mobileapp_green;

import android.service.autofill.FillContext;

import com.google.android.material.button.MaterialButton;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TableArrangement;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.Web;
import com.google.appinventor.components.runtime.WebViewer;
import com.google.appinventor.components.runtime.util.TimerInternal;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;

public class Main_Menu extends Form implements HandlesEventDispatching{

    private
    VerticalArrangement Main;

    HorizontalArrangement HorizontalArrangementM8;
    HorizontalArrangement HorizontalArrangementM1;
    HorizontalArrangement HorizontalArrangementM5;
    HorizontalArrangement HorizontalArrangementM3;
    HorizontalArrangement HorizontalArrangementM6;
    HorizontalArrangement HorizontalArrangementM4;
    HorizontalArrangement HorizontalArrangementM7;
    HorizontalArrangement HorizontalArrangementM9;
    HorizontalArrangement HorizontalArrangementM10;

    Button buttonM1, buttonM3, buttonM4 ;

    protected void $define() {
        Main = new VerticalArrangement(this);
        Main.BackgroundColor(1677721600);
        Main.WidthPercent(100);
        Main.HeightPercent(100);
        HorizontalArrangementM8 = new HorizontalArrangement(Main);
        HorizontalArrangementM8.Height(20);
        HorizontalArrangementM1 = new HorizontalArrangement(Main);
        buttonM1 = new Button(HorizontalArrangementM1);
        buttonM1.Text("Configuration");
        buttonM1.Height(60);
        buttonM1.FontSize(20);
        buttonM1.TextAlignment(Component.ALIGNMENT_CENTER);
       // HorizontalArrangementM5 = new HorizontalArrangement(Main);
       // HorizontalArrangementM5.Height(20);
        HorizontalArrangementM3 = new HorizontalArrangement(Main);
        buttonM3 = new Button(HorizontalArrangementM3);
        buttonM3.Text("View CO2 Details");
        buttonM3.Height(60);
        buttonM3.FontSize(20);
        buttonM3.TextAlignment(Component.ALIGNMENT_CENTER);
        HorizontalArrangementM6 = new HorizontalArrangement(Main);
        HorizontalArrangementM6.Height(20);
        HorizontalArrangementM4 = new HorizontalArrangement(Main);
        buttonM4 = new Button(HorizontalArrangementM4);
        buttonM4.Text("View Temperature Details");
        buttonM4.Height(60);
        buttonM4.FontSize(20);
        buttonM4.TextAlignment(Component.ALIGNMENT_CENTER);
        HorizontalArrangementM7 = new HorizontalArrangement(Main);
        HorizontalArrangementM7.Height(20);
        HorizontalArrangementM10 = new HorizontalArrangement(Main);
       // buttonM6 = new Button(HorizontalArrangementM10);
       // buttonM6.Text("Settings");
        //buttonM6.Height(60);
       // buttonM6.FontSize(20);
       // buttonM6.TextAlignment(Component.ALIGNMENT_CENTER);
       //buttonM5 = new Button(Main);
       // buttonM5.Text("Back");
       // buttonM5.FontSize(14);
        HorizontalArrangementM9 = new HorizontalArrangement(Main);
        HorizontalArrangementM9.HeightPercent(100);
        EventDispatcher.registerEventForDelegation(this, formName, "BackPressed");
        EventDispatcher.registerEventForDelegation(this, formName, "GotText");
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "OtherScreenClosed" );
        EventDispatcher.registerEventForDelegation(this, formName, "fachtnaWebViewStringChange");
    }

    public static void dbg (String debugMsg) {
        System.err.print( "~~~> " + debugMsg + " <~~~\n");
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {

        dbg("dispatchEvent: " + formName + " [" + component.toString() + "] [" + componentName + "] " + eventName);
        if (eventName.equals("BackPressed")) {
            this.finish();
            return true;
        } else if (eventName.equals("Click")) {
            if (component.equals(buttonM1)) {
                switchFormWithStartValue("Configuration", null);
                return true;
            }
            else if (component.equals(buttonM3)) {
                switchFormWithStartValue("Co2", null);
                return true;
            } else if (component.equals(buttonM4)) {
                switchFormWithStartValue("Temperature", null);
                return true;
            } //else if (component.equals(buttonM5)) {
               // switchFormWithStartValue("Home", null);
               // return true;
             //else if (component.equals(buttonM6)) {
               // switchFormWithStartValue("GeneralApplicationSettings", null);
               // return true;
           // }
        }
        return false;
    }
}
