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

public class Temperature extends Form implements HandlesEventDispatching {

    private
    VerticalScrollArrangement Temperature;

    HorizontalArrangement HorizontalArrangementT5;
    HorizontalArrangement HorizontalArrangementT3;
    HorizontalArrangement HorizontalArrangementT1;
    HorizontalArrangement HorizontalArrangementT2;
    HorizontalArrangement HorizontalArrangementT4;
    HorizontalArrangement HorizontalArrangementT6;


    Button buttonT1, buttonT2;

    Label LabelT1, LabelT2;

    protected void $define() {
        Temperature = new VerticalScrollArrangement(this);
        Temperature .BackgroundColor(1677721600);
        Temperature .WidthPercent(100);
        Temperature .HeightPercent(100);
        HorizontalArrangementT5 = new HorizontalArrangement(Temperature);
        HorizontalArrangementT5.Height(20);

        buttonT1 = new Button(Temperature);
        buttonT1.Text("Main Menu");
        buttonT1.FontSize(20);

        HorizontalArrangementT3 = new HorizontalArrangement(Temperature);
        HorizontalArrangementT3.Height(20);

        HorizontalArrangementT1 = new HorizontalArrangement(Temperature);
        LabelT1 = new Label(HorizontalArrangementT1);
        LabelT1.Text("Temperature Levels:");
        LabelT1.FontSize(17);

        LabelT2 = new Label(HorizontalArrangementT1);
        LabelT2.Text("12Hrs");
        LabelT2.FontSize(17);

        HorizontalArrangementT2 = new HorizontalArrangement(Temperature);
        HorizontalArrangementT2.Height(100);

        HorizontalArrangementT4 = new HorizontalArrangement(Temperature);
        HorizontalArrangementT4.Height(20);

        buttonT2 = new Button(Temperature);
        buttonT2.Text("Configure Lighting");
        buttonT2.FontSize(20);

        HorizontalArrangementT6= new HorizontalArrangement(Temperature);
        HorizontalArrangementT6.HeightPercent(100);
        EventDispatcher.registerEventForDelegation(this, formName, "BackPressed");
        EventDispatcher.registerEventForDelegation(this, formName, "GotText");
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "OtherScreenClosed");
        EventDispatcher.registerEventForDelegation(this, formName, "fachtnaWebViewStringChange");
    }

    public static void dbg (String debugMsg) {
        System.err.print( "~~~> " + debugMsg + " <~~~\n");
    }
    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {

        dbg("dispatchEvent: " + formName + " [" + component.toString() + "] [" + componentName + "] " + eventName);
        if (eventName.equals("BackPressed")) {
            return true;
        } else if (eventName.equals("Click")) {
            if (component.equals(buttonT1)) {
                switchFormWithStartValue("Main_Menu", null);
                return true;
            }
            else if (component.equals(buttonT2)){
                switchFormWithStartValue("Temperature", null);
                return true;
            }

        }
        return false;
    }
}
