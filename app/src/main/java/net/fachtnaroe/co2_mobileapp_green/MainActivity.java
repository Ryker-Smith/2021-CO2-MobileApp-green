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
    VerticalArrangement Screen1;
    HorizontalArrangement HorizontalArrangement1, HorizontalArrangement2, HorizontalArrangement3, HorizontalArrangement4, HorizontalArrangement5, HorizontalArrangementP;
    VerticalArrangement VerticalArrangement1;
    Label Null, Co2, Co2Reading, Co2Measurement,Temp, TempReading, TempMeasurement, SelectedNetwork;
    Clock clock, timer, timeout, timerinterval;
    TextBox NetworkSelection, NetworkSelection1, NetworkSelection2;
    Button SettingsButton, GoButton;
    Web connectionDemo, Relay, connectionRelay;
    Notifier notifier_Messages;
    String Data = "https://t.fachtnaroe.net/qndco2?";
    String Data1 = "https://t.fachtnaroe.net/qndco2?";

    protected void $define() {
        //Screen1-VScrollArrangement
        this.Sizing("Responsive");
        Screen1 = new VerticalArrangement(this);
        notifier_Messages = new Notifier(this);
        Screen1.HeightPercent(100);
        Screen1.WidthPercent(100);
        Screen1.AlignVertical(1);
        Screen1.AlignHorizontal(1);
        Screen1.BackgroundColor(Color.parseColor("#9DC183"));


        //VerticalArrangement1
        VerticalArrangement1 = new VerticalArrangement(Screen1);
        VerticalArrangement1.HeightPercent(50);
        VerticalArrangement1.WidthPercent(100);
        VerticalArrangement1.BackgroundColor(Color.parseColor("#9DC183"));

        HorizontalArrangement1 = new HorizontalArrangement(Screen1);

        //Button-VerticalArrangement1
        SettingsButton = new Button(VerticalArrangement1);
        SettingsButton.Height(50);
        SettingsButton.WidthPercent(100);
        SettingsButton.FontBold(true);
        SettingsButton.FontSize(16);
        SettingsButton.Text("Pair Device");
        SettingsButton.TextAlignment(1);
        //Label-VerticalArrangement1
        SelectedNetwork = new Label(VerticalArrangement1);
        SelectedNetwork.WidthPercent(0);
        SelectedNetwork.HeightPercent(0);
        SelectedNetwork.Text("Selected Network");
        SelectedNetwork.FontSize(14);
        SelectedNetwork.TextAlignment(1);
        SelectedNetwork.HasMargins(true);
        //Label-VerticalArrangement1
        NetworkSelection = new TextBox(VerticalArrangement1);
        NetworkSelection.HeightPercent(0);
        NetworkSelection.WidthPercent(0);
        NetworkSelection.BackgroundColor(Color.parseColor("#9DC183"));
        NetworkSelection.FontSize(25);
        NetworkSelection.TextAlignment(1);
        NetworkSelection.Text("sensor=CO2&device=TCFE-CO2-E1-2C");
        NetworkSelection1 = new TextBox(VerticalArrangement1);
        NetworkSelection1.HeightPercent(0);
        NetworkSelection1.WidthPercent(0);
        NetworkSelection1.BackgroundColor(Color.parseColor("#9DC183"));
        NetworkSelection1.FontSize(25);
        NetworkSelection1.TextAlignment(1);
        NetworkSelection1.Text("sensor=CELCIUS&device=TCFE-CO2-E1-2C");
        NetworkSelection2 = new TextBox(VerticalArrangement1);
        NetworkSelection2.HeightPercent(0);
        NetworkSelection2.WidthPercent(0);
        NetworkSelection2.BackgroundColor(Color.parseColor("#9DC183"));
        NetworkSelection2.FontSize(25);
        NetworkSelection2.TextAlignment(1);
        NetworkSelection2.Text("sensor=VOC&device=TCFE-CO2-E1-2C");
//        NetworkSelection.HasMargins(false);
        //Label-VerticalArrangement1
        Null = new Label(VerticalArrangement1);
        Null.HeightPercent(20);
        //Button-VerticalArrangement1
        GoButton = new Button(VerticalArrangement1);
        GoButton.Height(50);
        GoButton.WidthPercent(100);
        GoButton.Text("Refresh");
        GoButton.FontBold(true);
        GoButton.FontSize(16);
        GoButton.TextAlignment(1);
        GoButton.BackgroundColor(Color.parseColor("#000000"));
        SettingsButton.BackgroundColor(Color.parseColor("#151f76"));

        //HorizontalArrangement2
        HorizontalArrangement2 = new HorizontalArrangement(Screen1);
        HorizontalArrangement2.AlignHorizontal(1);
        HorizontalArrangement2.AlignVertical(1);
        HorizontalArrangement2.HeightPercent(10);
        HorizontalArrangement2.WidthPercent(100);
        HorizontalArrangement2.BackgroundColor(Color.parseColor("#1d339e"));
        //Co2-HorizontalArrangement2
        Co2 = new Label(HorizontalArrangement2);
        Co2.HeightPercent(10);
        Co2.WidthPercent(30);
        Co2.Text("CO2:");
        Co2.TextColor(Color.parseColor("#FFFAF0"));
        Co2.TextAlignment(2);
        Co2.HasMargins(false);
        Co2.FontBold(true);
        Co2.FontSize(38);
        Co2.FontItalic(true);
        Co2.HasMargins(false);
        Co2.FontItalic(true);
        //Co2Reading-HorizontalArrangement2
        Co2Reading = new Label(HorizontalArrangement2);
        Co2Reading.HeightPercent(10);
        Co2Reading.WidthPercent(40);
        // Co2Reading.Text("0576");
        Co2Reading.TextColor(Color.parseColor("#FFFAF0"));
        Co2Reading.TextAlignment(1);
        Co2Reading.HasMargins(false);
        Co2Reading.FontBold(true);
        Co2Reading.FontSize(38);
        Co2Reading.FontItalic(true);
        Co2Reading.HasMargins(false);
        Co2Reading.FontItalic(true);
        //Co2Measurement-HorizontalArrangement2
        Co2Measurement = new Label(HorizontalArrangement2);
        Co2Measurement.HeightPercent(10);
        Co2Measurement.WidthPercent(30);
        Co2Measurement.Text("ppm");
        Co2Measurement.TextColor(Color.parseColor("#FFFAF0"));
        Co2Measurement.TextAlignment(0);
        Co2Measurement.HasMargins(false);
        Co2Measurement.FontBold(true);
        Co2Measurement.FontSize(38);
        Co2Measurement.FontItalic(true);
        Co2Measurement.HasMargins(false);
        Co2Measurement.FontItalic(true);

        HorizontalArrangementP = new HorizontalArrangement(Screen1);
        HorizontalArrangementP.Height(75);
        HorizontalArrangementP.WidthPercent(100);

        //HorizontalArrangement4
        HorizontalArrangement4 = new HorizontalArrangement(Screen1);
        HorizontalArrangement4.AlignHorizontal(1);
        HorizontalArrangement4.AlignVertical(1);
        HorizontalArrangement4.HeightPercent(10);
        HorizontalArrangement4.WidthPercent(100);
        HorizontalArrangement4.BackgroundColor(Color.parseColor("#1f3cbd"));
        //Temp-HorizontalArrangement4
        Temp = new Label(HorizontalArrangement4);
        Temp.HeightPercent(10);
        Temp.WidthPercent(31);
        Temp.Text("TEMP:");
        Temp.TextColor(Color.parseColor("#FFFAF0"));
        Temp.TextAlignment(2);
        Temp.HasMargins(false);
        Temp.FontBold(true);
        Temp.FontSize(38);
        Temp.FontItalic(true);
        Temp.HasMargins(false);
        Temp.FontItalic(true);
        //TempReading-HorizontalArrangement4
        TempReading = new Label(HorizontalArrangement4);
        TempReading.HeightPercent(10);
        TempReading.WidthPercent(40);
        //  TempReading.Text("19.7");
        TempReading.TextColor(Color.parseColor("#FFFAF0"));
        TempReading.TextAlignment(1);
        TempReading.HasMargins(false);
        TempReading.FontBold(true);
        TempReading.FontSize(38);
        TempReading.FontItalic(true);
        TempReading.HasMargins(false);
        TempReading.FontItalic(true);
        //TempMeasurement-HorizontalArrangement4
        TempMeasurement = new Label(HorizontalArrangement4);
        TempMeasurement.HeightPercent(10);
        TempMeasurement.WidthPercent(30);
        TempMeasurement.Text("C°");
        TempMeasurement.TextColor(Color.parseColor("#FFFAF0"));
        TempMeasurement.TextAlignment(0);
        TempMeasurement.HasMargins(false);
        TempMeasurement.FontBold(true);
        TempMeasurement.FontSize(38);
        TempMeasurement.FontItalic(true);
        TempMeasurement.HasMargins(false);
        TempMeasurement.FontItalic(true);

        //HorizontalArrangement5
        HorizontalArrangement5 = new HorizontalArrangement(Screen1);
        HorizontalArrangement5.Height(150);
        HorizontalArrangement5.WidthPercent(100);

        //Web-connectionDemo
        connectionDemo = new Web(this);
        connectionDemo.Url("addressOfData");
        Relay = new Web(this);
        Relay.Url("addressOfData1");
        connectionRelay = new Web(this);
        connectionRelay.Url("addressOfData1");

        //Event Dispatcher
        EventDispatcher.registerEventForDelegation(this, formName, "BackPressed");
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "GotText");
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {
        dbg("dispatchEvent: " + formName + " [" + component.toString() + "] [" + componentName + "] " + eventName);
        if (eventName.equals("BackPressed")) {
            return true;
        }
        else if (eventName.equals("GotText")) {
            if (component.equals(connectionDemo)) {
                String status = params[1].toString();
                String textOfResponse = (String) params[3];
                manageResponse(component, status, textOfResponse);
            }
            else
            if (component.equals(Relay)) {
                String status = params[1].toString();
                String textOfResponse = (String) params[3];
                manageResponse(component, status, textOfResponse);
            }
            else
            if (component.equals(connectionRelay)) {
                String status = params[1].toString();
                String textOfResponse = (String) params[3];
                manageResponse(component, status, textOfResponse);
            }
        }
        else if (eventName.equals("Click")) {
            if (component.equals(GoButton)) {
                dbg("k");
                connectionDemo.Url(Data + NetworkSelection.Text());
                connectionDemo.Get();

                Relay.Url(Data1 + NetworkSelection1.Text());
                Relay.Get();
                dbg(connectionDemo.Url());

                connectionRelay.Url(Data1 + NetworkSelection2.Text());
                connectionRelay.Get();
                dbg(connectionDemo.Url());
                return true;
            }
        }
        return false;
    }

    void manageResponse(Component c, String status, String textOfResponse) {
        dbg("GOT SOME TEXT");
        if (status.equals("200")) try {
            JSONObject parser = new JSONObject(textOfResponse);
            if (parser.getString("Status").equals("OK")) {
                dbg("gh");
                if (c.equals(connectionDemo)) {
                    Co2Reading.Text(parser.getString("value"));
                }
                else {
                    TempReading.Text(parser.getString("value"));
                }
                if (c.equals(connectionRelay)){
                    //TVOCReading.Text(parser.getString("value"));
                }
            }
        }
        catch (JSONException e) {
            notifier_Messages.ShowAlert("JSON exception(" + textOfResponse + ")");
        }
    }
    public static void dbg (String debugMsg) {
        System.err.println("~~~>" + debugMsg + "<~~~\n");
    }
}