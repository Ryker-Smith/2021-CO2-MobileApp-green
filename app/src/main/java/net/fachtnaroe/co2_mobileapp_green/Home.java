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

public class Home extends Form implements HandlesEventDispatching {

    private
    VerticalArrangement Home;
    HorizontalArrangement HorizontalArrangementH6;
    HorizontalArrangement HorizontalArrangementH1;
    HorizontalArrangement HorizontalArrangementH3;
    HorizontalArrangement HorizontalArrangementH2;
    HorizontalArrangement HorizontalArrangementH4;
    HorizontalArrangement HorizontalArrangementH7;

    Button buttonH1;
    Label Label1, Label2, LabelCo2,LabelT, Labelppm, LabelC;

    protected void $define() {
        this.Sizing("Responsive");
        dbg("A");
        Home = new VerticalArrangement(this);
        Home.AlignHorizontal(2);
        Home.BackgroundColor(-13755833);
        HorizontalArrangementH6 = new HorizontalArrangement(Home);
        HorizontalArrangementH6.Height(24);
        HorizontalArrangementH1 = new HorizontalArrangement(Home);
        HorizontalArrangementH1.Height(64);
        HorizontalArrangementH1.WidthPercent(100);
        HorizontalArrangementH1.AlignHorizontal(Component.ALIGNMENT_NORMAL);
        Label1 = new Label(HorizontalArrangementH1);
        Label1.FontSize(35);
        Label1.Height(45);
        Label1.WidthPercent(50);
        Label1.TextAlignment(Component.ALIGNMENT_CENTER);
        Label1.Text("Co2");
        LabelCo2 = new Label(HorizontalArrangementH1);
        LabelCo2.FontSize(35);
        LabelCo2.Height(45);
        LabelCo2.WidthPercent(25);
        LabelCo2.TextAlignment(Component.ALIGNMENT_OPPOSITE);
        LabelCo2.Text("444");
        Labelppm = new Label(HorizontalArrangementH1);
        Labelppm.FontSize(35);
        Labelppm.Height(45);
        Labelppm.WidthPercent(25);
        Labelppm.TextAlignment(Component.ALIGNMENT_NORMAL);
        Labelppm.Text("ppm");
        HorizontalArrangementH3 = new HorizontalArrangement(Home);
        HorizontalArrangementH3.Height(20);
        HorizontalArrangementH2 = new HorizontalArrangement(Home);
        HorizontalArrangementH2.Height(64);
        HorizontalArrangementH2.WidthPercent(100);
        Label2 = new Label(HorizontalArrangementH2);
        Label2.FontSize(35);
        Label2.Height(45);
        Label2.WidthPercent(60);
        Label2.TextAlignment(Component.ALIGNMENT_CENTER);
        Label2.Text("Temperature");
        LabelT = new Label(HorizontalArrangementH2);
        LabelT.FontSize(35);
        LabelT.Height(45);
        LabelT.WidthPercent(20);
        LabelT.TextAlignment(Component.ALIGNMENT_OPPOSITE);
        LabelT.Text("44");
        LabelC = new Label(HorizontalArrangementH2);
        LabelC.FontSize(35);
        LabelC.Height(45);
        LabelC.WidthPercent(20);
        LabelC.TextAlignment(Component.ALIGNMENT_NORMAL);
        LabelC.Text("°C");
        HorizontalArrangementH4 = new HorizontalArrangement(Home);
        HorizontalArrangementH4.Height(20);
        buttonH1 = new Button(Home);
        buttonH1.Height(60);
        buttonH1.WidthPercent(100);
        buttonH1.Text("More Information");
        buttonH1.TextColor(-16777216);
        buttonH1.FontSize(20);
        HorizontalArrangementH7 = new HorizontalArrangement(Home);
        HorizontalArrangementH7.HeightPercent(100);
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
            if (component.equals(buttonH1)) {
                switchFormWithStartValue("Main_Menu", null);

            }

        }
        return true;
    }

}
