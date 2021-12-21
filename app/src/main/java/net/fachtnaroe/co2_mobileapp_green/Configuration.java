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

public class Configuration extends Form implements HandlesEventDispatching {
    private VerticalArrangement Configuration;

    HorizontalArrangement HorizontalArrangementC1;
    HorizontalArrangement HorizontalArrangementC2;
    HorizontalArrangement HorizontalArrangementC3;
    HorizontalArrangement HorizontalArrangementC4;
    HorizontalArrangement HorizontalArrangementC5;

    Button buttonC1, buttonC2, buttonC3;


    protected void $define() {
        Configuration = new VerticalArrangement(this);
        Configuration.BackgroundColor(1677721600);
        Configuration.HeightPercent(100);
        Configuration.WidthPercent(100);

        HorizontalArrangementC3 = new HorizontalArrangement(Configuration);
        HorizontalArrangementC3.Height(20);

        buttonC2 = new Button(Configuration);
        buttonC2.Text("Main Menu");
        buttonC2.FontSize(14);

        HorizontalArrangementC2 = new HorizontalArrangement(Configuration);
        HorizontalArrangementC2.Height(20);

        buttonC3 = new Button(Configuration);
        buttonC3.Text("Configure Device for WiFi");
        buttonC3.FontSize(20);

        HorizontalArrangementC4 = new HorizontalArrangement(Configuration);
        HorizontalArrangementC4.Height(20);

        HorizontalArrangementC1 = new HorizontalArrangement(Configuration);
        HorizontalArrangementC1.Height(20);

        buttonC1 = new Button(Configuration);
        buttonC1.Text("Change Connection");
        buttonC1.FontSize(20);
        HorizontalArrangementC5 = new HorizontalArrangement(Configuration);
        HorizontalArrangementC5.HeightPercent(100);
        EventDispatcher.registerEventForDelegation(this, formName, "BackPressed");
        EventDispatcher.registerEventForDelegation(this, formName, "GotText");
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "OtherScreenClosed");
        EventDispatcher.registerEventForDelegation(this, formName, "fachtnaWebViewStringChange");
    }

    public static void dbg(String debugMsg) {
        System.err.print("~~~> " + debugMsg + " <~~~\n");
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {

        dbg("dispatchEvent: " + formName + " [" + component.toString() + "] [" + componentName + "] " + eventName);
        if (eventName.equals("BackPressed")) {
            return true;
        } else if (eventName.equals("Click")) {
            if (component.equals(buttonC2)) {
                switchFormWithStartValue("Main_Menu", null);

            }

        }
        return true;


    }
}
