package  green;



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

public class ainActivity extends Form implements HandlesEventDispatching {

    private
   VerticalScrollArrangement Home, Main, Configuration, Co2, Temperature;

    HorizontalArrangement HorizontalArrangementH6;
    HorizontalArrangement HorizontalArrangementH1;
    HorizontalArrangement HorizontalArrangementH3;
    HorizontalArrangement HorizontalArrangementH2;
    HorizontalArrangement HorizontalArrangementH4;
    HorizontalArrangement HorizontalArrangementH7;

    HorizontalArrangement HorizontalArrangementM8;
    HorizontalArrangement HorizontalArrangementM1;
    HorizontalArrangement HorizontalArrangementM5;
    HorizontalArrangement HorizontalArrangementM3;
    HorizontalArrangement HorizontalArrangementM6;
    HorizontalArrangement HorizontalArrangementM4;
    HorizontalArrangement HorizontalArrangementM7;

    HorizontalArrangement HorizontalArrangementC1;
    HorizontalArrangement HorizontalArrangementC2;
    HorizontalArrangement HorizontalArrangementC3;
    HorizontalArrangement HorizontalArrangementC4;

    HorizontalArrangement HorizontalArrangementCo5;
    HorizontalArrangement HorizontalArrangementCo3;
    HorizontalArrangement HorizontalArrangementCo1;
    HorizontalArrangement HorizontalArrangementCo2;
    HorizontalArrangement HorizontalArrangementCo4;

    HorizontalArrangement HorizontalArrangementT5;
    HorizontalArrangement HorizontalArrangementT3;
    HorizontalArrangement HorizontalArrangementT1;
    HorizontalArrangement HorizontalArrangementT2;
    HorizontalArrangement HorizontalArrangementT4;


    TextBox box_One, box_Two;
    Button buttonH1;
    Button buttonM1, buttonM5, buttonM3, buttonM4;
    Button buttonC1, buttonC2, buttonC3;
    Button buttonCo1, buttonCo2;
    Button buttonT1, buttonT2;
    Label Label1, Label2;
    Label LabelCo1, LabelCo2;
    Label LabelT1, LabelT2;
    Web Relay;
    Notifier notifier_Messages;
    String addressOfData = "https://t.fachtnaroe.net/qndco2?";

    protected void $define() {

        this.Sizing("Responsive");
     dbg("B");
        switchFormWithStartValue("Home","1");
     dbg("C");
//        Home = new VerticalScrollArrangement(this);
//        Home.AlignHorizontal(2);
//        Home.BackgroundColor(1677721600);
//        Home.HeightPercent(100);
//        HorizontalArrangementH6 = new HorizontalArrangement(Home);
//        HorizontalArrangementH6.Height(24);
//        HorizontalArrangementH1 = new HorizontalArrangement(Home);
//        HorizontalArrangementH1.Height(64);
//        HorizontalArrangementH1.WidthPercent(100);
//        Label1 = new Label(HorizontalArrangementH1);
//        Label1.FontSize(35);
//        Label1.Height(45);
//        Label1.WidthPercent(100);
//        Label1.TextAlignment(Component.ALIGNMENT_CENTER);
//        Label1.Text("com.example.mit.Co2");
//        HorizontalArrangementH3 = new HorizontalArrangement(Home);
//        HorizontalArrangementH3.Height(20);
//        HorizontalArrangementH2 = new HorizontalArrangement(Home);
//        HorizontalArrangementH2.Height(64);
//        HorizontalArrangementH2.WidthPercent(100);
//        Label2 = new Label(HorizontalArrangementH2);
//        Label2.FontSize(35);
//        Label2.Height(45);
//        Label2.WidthPercent(100);
//        Label2.TextAlignment(Component.ALIGNMENT_CENTER);
//        Label2.Text("Temperature");
//        HorizontalArrangementH4 = new HorizontalArrangement(Home);
//        HorizontalArrangementH4.Height(20);
//        buttonH1 = new Button(Home);
//        buttonH1.Height(40);
//        buttonH1.WidthPercent(100);
//        buttonH1.Text("More Information");
//        buttonH1.TextColor(-16777216);
//        buttonH1.FontSize(20);
//        HorizontalArrangementH7 = new HorizontalArrangement(Home);
//        HorizontalArrangementH7.Height(20);
//
//
//        Main = new VerticalScrollArrangement(this );
//
//        HorizontalArrangementM8 = new HorizontalArrangement(Main);
//        HorizontalArrangementM8.Height(20);
//
//        HorizontalArrangementM1 = new HorizontalArrangement(Main);
//        buttonM1 = new Button(HorizontalArrangementM1);
//        buttonM1.Text("Configure WiFi Connection");
//        buttonM1.Height(40);
//        buttonM1.FontSize(20);
//        buttonM1.TextAlignment(Component.ALIGNMENT_CENTER);
//
//        HorizontalArrangementM5 = new HorizontalArrangement(Main);
//        HorizontalArrangementM5.Height(20);
//
//        HorizontalArrangementM3 = new HorizontalArrangement(Main);
//        buttonM3 = new Button(HorizontalArrangementM3);
//        buttonM3.Text("View CO2 Details");
//        buttonM3.Height(40);
//        buttonM3.FontSize(20);
//        buttonM3.TextAlignment(Component.ALIGNMENT_CENTER);
//
//        HorizontalArrangementM6 = new HorizontalArrangement(Main);
//        HorizontalArrangementM6.Height(20);
//
//        HorizontalArrangementM4 = new HorizontalArrangement(Main);
//        buttonM4 = new Button(HorizontalArrangementM4);
//        buttonM4.Text("View Temperature Details");
//        buttonM4.Height(40);
//        buttonM4.FontSize(20);
//        buttonM4.TextAlignment(Component.ALIGNMENT_CENTER);
//
//        HorizontalArrangementM7 = new HorizontalArrangement(Main);
//        HorizontalArrangementM7.Height(20);
//
//        buttonM5 = new Button(Main);
//        buttonM5.Text("Back");
//        buttonM5.FontSize(14);
//
//
//
//
//        Configuration = new VerticalScrollArrangement(this);
//
//        HorizontalArrangementC3 = new HorizontalArrangement(Configuration);
//        HorizontalArrangementC3.Height(20);
//
//        buttonC2 = new Button(Configuration);
//        buttonC2.Text("Main Menu");
//        buttonC2.FontSize(14);
//
//        HorizontalArrangementC2 = new HorizontalArrangement(Configuration);
//        HorizontalArrangementC2.Height(20);
//
//        buttonC3 = new Button(Configuration);
//        buttonC3.Text("Configure Device for WiFi");
//        buttonC3.FontSize(20);
//
//        HorizontalArrangementC4 = new HorizontalArrangement(Configuration);
//        HorizontalArrangementC4.Height(20);
//
//        HorizontalArrangementC1 = new HorizontalArrangement(Configuration);
//        HorizontalArrangementC1.Height(20);
//
//        buttonC1 = new Button(Configuration);
//        buttonC1.Text("Change Connection");
//        buttonC1.FontSize(20);
//
//
//
//        Co2 = new VerticalScrollArrangement(this);
//        HorizontalArrangementCo5 = new HorizontalArrangement(Co2);
//        HorizontalArrangementCo5.Height(20);
//
//        buttonCo1 = new Button(Co2);
//        buttonCo1.Text("Main Menu");
//        buttonCo1.FontSize(20);
//
//        HorizontalArrangementCo3 = new HorizontalArrangement(Co2);
//        HorizontalArrangementCo3.Height(20);
//
//        HorizontalArrangementCo1 = new HorizontalArrangement(Co2);
//        LabelCo1 = new Label(HorizontalArrangementCo1);
//        LabelCo1.Text("CO2 Levels:");
//        LabelCo1.FontSize(17);
//
//        LabelCo2 = new Label(HorizontalArrangementCo1);
//        LabelCo2.Text("24Hrs");
//        LabelCo2.FontSize(17);
//
//        HorizontalArrangementCo2 = new HorizontalArrangement(Co2);
//        HorizontalArrangementCo2.Height(100);
//
//        HorizontalArrangementCo4 = new HorizontalArrangement(Co2);
//        HorizontalArrangementCo4.Height(20);
//
//        buttonCo2 = new Button(Co2);
//        buttonCo2.Text("Configure Lighting");
//        buttonCo2.FontSize(20);
//
//
//
//        Temperature = new VerticalScrollArrangement(this);
//        HorizontalArrangementT5 = new HorizontalArrangement(Temperature);
//        HorizontalArrangementT5.Height(20);
//
//        buttonT1 = new Button(Temperature);
//        buttonT1.Text("Main Menu");
//        buttonT1.FontSize(20);
//
//        HorizontalArrangementT3 = new HorizontalArrangement(Temperature);
//        HorizontalArrangementT3.Height(20);
//
//        HorizontalArrangementT1 = new HorizontalArrangement(Temperature);
//        LabelT1 = new Label(HorizontalArrangementT1);
//        LabelT1.Text("Temperature Levels:");
//        LabelT1.FontSize(17);
//
//        LabelT2 = new Label(HorizontalArrangementCo1);
//        LabelT2.Text("12Hrs");
//        LabelT2.FontSize(17);
//
//        HorizontalArrangementT2 = new HorizontalArrangement(Temperature);
//        HorizontalArrangementT2.Height(100);
//
//        HorizontalArrangementT4 = new HorizontalArrangement(Temperature);
//        HorizontalArrangementT4.Height(20);
//
//        buttonT2 = new Button(Temperature);
//        buttonT2.Text("Configure Lighting");
//        buttonT2.FontSize(20);

    }

 public static void dbg (String debugMsg) {
  System.err.print("~~~> " + debugMsg + " <~~~\n");
 }


}
