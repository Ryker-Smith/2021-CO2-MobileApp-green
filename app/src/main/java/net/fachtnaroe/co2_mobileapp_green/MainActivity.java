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

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Switch;


public class MainActivity extends Form implements HandlesEventDispatching {

    private
    VerticalArrangement Home;
    HorizontalArrangement HorizontalArrangementH6;
    HorizontalArrangement HorizontalArrangementH1;
    HorizontalArrangement HorizontalArrangementH3;
    HorizontalArrangement HorizontalArrangementH2;
    HorizontalArrangement HorizontalArrangementH4;
    HorizontalArrangement HorizontalArrangementH7;

    Button buttonH1;
    Label Label1, Label2,LabelT, LabelC, Labelppm;
    TextBox LabelCo2andTemp;
    Web Relay;
    protected void $define() {
        // This is just to show that we can
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
        Label1.Text("Co2/Temp");
        LabelCo2andTemp = new TextBox(HorizontalArrangementH1);
        LabelCo2andTemp.FontSize(35);
        LabelCo2andTemp.Height(55);
        LabelCo2andTemp.WidthPercent(25);
        LabelCo2andTemp.TextAlignment(Component.ALIGNMENT_OPPOSITE);
        LabelCo2andTemp.Text();
        Labelppm = new Label(HorizontalArrangementH1);
        Labelppm.FontSize(25);
        Labelppm.Height(35);
        Labelppm.WidthPercent(15);
        Labelppm.TextAlignment(Component.ALIGNMENT_NORMAL);
        Labelppm.Text();
        HorizontalArrangementH3 = new HorizontalArrangement(Home);
        HorizontalArrangementH3.Height(20);
        HorizontalArrangementH2 = new HorizontalArrangement(Home);
        HorizontalArrangementH2.Height(64);
        HorizontalArrangementH2.WidthPercent(100);
        LabelT = new Label(HorizontalArrangementH2);
        LabelT.FontSize(35);
        LabelT.Height(45);
        LabelT.WidthPercent(20);
        LabelT.TextAlignment(Component.ALIGNMENT_OPPOSITE);
        LabelT.Text();
        LabelC = new Label(HorizontalArrangementH2);
        LabelC.FontSize(35);
        LabelC.Height(45);
        LabelC.WidthPercent(20);
        LabelC.TextAlignment(Component.ALIGNMENT_NORMAL);
        LabelC.Text();
        HorizontalArrangementH4 = new HorizontalArrangement(Home);
        HorizontalArrangementH4.Height(20);
        buttonH1 = new Button(Home);
        buttonH1.Height(60);
        buttonH1.WidthPercent(100);
        buttonH1.Text("Press for Readings");
        buttonH1.TextColor(-16777216);
        buttonH1.FontSize(20);
        HorizontalArrangementH7 = new HorizontalArrangement(Home);
        HorizontalArrangementH7.HeightPercent(100);
        Relay = new Web(Home);
        EventDispatcher.registerEventForDelegation(this, formName, "BackPressed");
        EventDispatcher.registerEventForDelegation(this, formName, "GotText");
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "OtherScreenClosed" );
        EventDispatcher.registerEventForDelegation(this, formName, "fachtnaWebViewStringChange");

    }



    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {

        dbg("dispatchEvent: " + formName + " [" + component.toString() + "] [" + componentName + "] " + eventName);
        if (eventName.equals("BackPressed")) {
            return true;
        } else if (eventName.equals("Click")) {
            if (component.equals(buttonH1)) {
                dbg("HELLO2");
              //  switchFormWithStartValue("Main_Menu", null);
                Relay.Url("https://t.fachtnaroe.net/qndco2?device=TCFE-CO2-0C-AA&sensor=CO2");
                Relay.Get();

                Relay.Url("https://t.fachtnaroe.net/qndco2?device=TCFE-CO2-0C-AA&sensor=CELCIUS");
                Relay.Get();

            }

        }
        else if (eventName.equals("GotText")) {
            if (component.equals(Relay)) {
                String status = params[1].toString();
                String textOfResponse = (String) params[3];
                handleNetworkResponse(component, status, textOfResponse);
                dbg("HELLO");
                return true;

            }
        }
        return true;
    }


    void handleNetworkResponse(Component c, String status, String textOfResponse) {
        dbg(("<br><b>" + "some message here" + ":</b> " + textOfResponse + "<br>"));
        if (status.equals("200")) try {
            JSONObject parser = new JSONObject(textOfResponse);
            if (parser.getString("Status").equals("OK")) {
                if (c.equals(Relay)) {
                  LabelCo2andTemp.Text(parser.getString("value"));
                }
            }
        }
        catch(JSONException e){
            dbg("Android JSON exception (" + textOfResponse + ")");
        }
        else{
            dbg("Status is " + status);
        }
    }

    public static void dbg (String debugMsg) {
        System.err.println( "~~~> " + debugMsg + " <~~~\n");
    }
    public static boolean isNumeric(String string) {
        int intValue;
        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException e) {
            //
        }
        return false;
    }
 }
