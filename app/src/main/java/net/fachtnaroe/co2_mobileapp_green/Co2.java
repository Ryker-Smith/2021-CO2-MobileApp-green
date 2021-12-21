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

public class Co2 extends Form implements HandlesEventDispatching {
    private VerticalScrollArrangement Co2;

    HorizontalArrangement HorizontalArrangementCo5;
    HorizontalArrangement HorizontalArrangementCo3;
    HorizontalArrangement HorizontalArrangementCo1;
    HorizontalArrangement HorizontalArrangementCo2;
    HorizontalArrangement HorizontalArrangementCo4;
    HorizontalArrangement HorizontalArrangementCo6;

    Button buttonCo1, buttonCo2;

    Label LabelCo1, LabelCo2;

    protected void $define() {

        Co2 = new VerticalScrollArrangement(this);
        Co2.BackgroundColor(1677721600);
        Co2.WidthPercent(100);
        Co2.HeightPercent(100);

        HorizontalArrangementCo5 = new HorizontalArrangement(Co2);
        HorizontalArrangementCo5.Height(20);

        buttonCo1 = new Button(Co2);
        buttonCo1.Text("Main Menu");
        buttonCo1.FontSize(20);

        HorizontalArrangementCo3 = new HorizontalArrangement(Co2);
        HorizontalArrangementCo3.Height(20);

        HorizontalArrangementCo1 = new HorizontalArrangement(Co2);

        LabelCo1 = new Label(HorizontalArrangementCo1);
        LabelCo1.Text("CO2 Levels:");
        LabelCo1.FontSize(17);

        LabelCo2 = new Label(HorizontalArrangementCo1);
        LabelCo2.Text("24Hrs");
        LabelCo2.FontSize(17);

        HorizontalArrangementCo2 = new HorizontalArrangement(Co2);
        HorizontalArrangementCo2.Height(100);

        HorizontalArrangementCo4 = new HorizontalArrangement(Co2);
        HorizontalArrangementCo4.Height(20);

        buttonCo2 = new Button(Co2);
        buttonCo2.Text("Configure Lighting");
        buttonCo2.FontSize(20);
        HorizontalArrangementCo6 = new HorizontalArrangement(Co2);
        HorizontalArrangementCo6.HeightPercent(100);
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
            return true;
        } else if (eventName.equals("Click")) {
            if (component.equals(buttonCo1)) {
                switchFormWithStartValue("Main_Menu", null);
                return true;
            }
            else if (component.equals(buttonCo2)){
                switchFormWithStartValue("Co2", null);
                return true;
            }

        }
        return false;
    }
        
}
