package com.jakegosskuehn.easycontactinput;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class settingmenu extends Activity {
    final Context context = this;
    public View view;
    public SharedPreferences sp;
    public SharedPreferences.Editor e;
    public boolean autosms;
    public boolean showbox;
    
    public String finishedtext(String userstring)
    {
        
        String smsintroduction = sp.getString("intro", "");
        String smsbody = sp.getString("body", "");
        String checkboxtext = sp.getString("checkbody", "");
        String checkboxmessage = sp.getString("checkboxdescr", "");
        
        if(smsintroduction.isEmpty()) 
        {
            if(smsbody.isEmpty())
            {
                if(checkboxtext.isEmpty())
                    
                {
                    if(checkboxmessage.isEmpty()) //topkek for most AND statements Ive ever put in in if/then form
                    {
                        //Essentially the DEFAULT if they're ALL null
                        smsbody = "Hi "+ userstring +". I just met you and my phone is sending this message. ";
                    }
                }
            }
        }

        
        String thetext = "";
        String Namestring = "Hi " + userstring + ", this is "+ smsintroduction + ".";
        
        thetext = Namestring + " " + smsbody + " " + checkboxtext;
        
        return thetext;
    }
    
    public void save(View view)
    {
        //THINGS HAPPEN HERE WITH SHARED PREFERENCES :(
        savethethings();
        setthecompletetext();
        this.finish();
        return;
    }
    
    private void setthecompletetext() {
        // TODO Auto-generated method stub
        savethethings();
        TextView thecompletedtext = (TextView) findViewById(R.id.completed_text);
        String smsbodytest = finishedtext("Their Name");
        thecompletedtext.setText(smsbodytest);
    }

    public void help(View view)
    {
        this.finish();
        return;
    }
    
    public void cancel(View view)
    {
        this.finish();
        return;
    }
    
    public void watchtext()
    {
        
//        String smsintroduction = sp.getString("intro", "");
//        String smsbody = sp.getString("body", "");
//        String checkboxtext = sp.getString("checkbody", "");
//        String checkboxmessage = sp.getString("checkboxdescr", "");
        
        new AlertDialog.Builder(this)
        .setTitle("Setting Explanation")
        .setMessage("Here we are trying to edit what the text will show when the user fills in their information and presses enter. The sms should include their name, as its how you will remember them in your constructed text. \n \n Intro Text: The text starts off as: blah blah blah 'persons input name'. Plan your body accordingly. \n \n Textbody: The main part of the text that gets made. \n \n Checkbox Message: Is what words will be added on the end of your text IF the checkbox was marked when enter was pressed. \n \n Checkbox Description: What the describing text will say next to the checkbox on the main page. \n \n Show Checkbox: Chooses to enable the checkbox in the main page, some people don't like it. \n \n Auto SMS: Instead of a text popping up where the user can see it and send by themselves, when enabled, the text automatically sends. The text may not show in your android phone's text app which defeats the purpose of this app. ")
        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) { 
                // continue with delete
            }
         })
//        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) { 
//                // do nothing
//            }
//         })
       // .setIcon(R.drawable.ic_dialog_alert)
         .show();
    }
    
    public void alert(){
        
//      String smsintroduction = sp.getString("intro", "");
//      String smsbody = sp.getString("body", "");
//      String checkboxtext = sp.getString("checkbody", "");
//      String checkboxmessage = sp.getString("checkboxdescr", "");
//      
        new AlertDialog.Builder(this)
        .setTitle("Setting Explanation")
        .setMessage("Here we are trying to edit what the text will show when the user fills in their information and presses enter. The sms should include their name, as its how you will remember them in your constructed text. \n \n Intro Text: The text starts off as: blah blah blah 'persons input name'. Plan your body accordingly. \n \n Textbody: The main part of the text that gets made. \n \n Checkbox Message: Is what words will be added on the end of your text IF the checkbox was marked when enter was pressed. \n \n Checkbox Description: What the describing text will say next to the checkbox on the main page. \n \n Show Checkbox: Chooses to enable the checkbox in the main page, some people don't like it. \n \n Auto SMS: Instead of a text popping up where the user can see it and send by themselves, when enabled, the text automatically sends. The text may not show in your android phone's text app which defeats the purpose of this app. ")
        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) { 
                // continue with delete
            }
         })
//        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) { 
//                // do nothing
//            }
//         })
       // .setIcon(R.drawable.ic_dialog_alert)
         .show();
    }
    
    
    
//    
    //
    //FOR THE SECOND COMING FOR THE BOX CHECKERS
    
    
//    public boolean checkboxChecker()
//    {
//        CheckBox box1 = (CheckBox) findViewById(R.id.settings_checkbox1);
//        
//        
//             return true;   
//    }
//    
//    public boolean automaticSMSChecker()
//    {
//        CheckBox box2 = (CheckBox) findViewById(R.id.settings_checkbox2);
//        
//        return true;  
//    }
    
    public void savethethings(){ //run this when enter is pressed/save
        
        //automaticSMSChecker(); //check if it works first before using it...
        
//        checkboxChecker();
        
        EditText smsintro_hint = (EditText) findViewById(R.id.settings_smsintro_hint);
        EditText smsbody_hint = (EditText) findViewById(R.id.settings_smsbody_hint);
        EditText checkboxbody_hint = (EditText) findViewById(R.id.settings_checkboxbody_hint);
        EditText checkboxbody_description_hint = (EditText) findViewById(R.id.settings_checkboxbody_description_hint);
        
        
        String introstring = smsintro_hint.getText().toString();
        String bodystring = smsbody_hint.getText().toString();
      String checkboxbodystring = checkboxbody_hint.getText().toString();
      String checkboxdescriptionstring = checkboxbody_description_hint.getText().toString();
      
      //      if(!introstring.isEmpty()) //if the fields are NOT empty, they should get saved.
      //      {
          e.putString("intro", introstring);
          e.commit(); // you forgot to commit

      
      if(!bodystring.isEmpty())
      {
          e.putString("body", bodystring);
          e.commit(); 
      }
      
      if(!checkboxbodystring.isEmpty())
      {
          e.putString("checkbody", checkboxbodystring);
          e.commit(); 
      }
      
      if(!checkboxdescriptionstring.isEmpty())
      {
          e.putString("checkboxdescr", checkboxdescriptionstring);
          e.commit(); 
      }
      
      
      //test
      
    }
    
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.settingmenu);
//        
        //SP
        //sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); // forget about
        sp = getSharedPreferences("contactapp", 0);
        // named preferences - get the default ones and finish with it
        e = sp.edit();
        
        Button tt = (Button)findViewById(R.id.savebutton);
        tt.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                save(view);
                        
            }
        });
        
        Button tt2 = (Button)findViewById(R.id.helpButton);
        tt2.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                alert();
                        
            }
        });
        
        Button tt3 = (Button)findViewById(R.id.cancelButton);
        tt3.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                    finish();
                        
            }
        });
        
        Button tt4 = (Button)findViewById(R.id.checkMessage);
        tt4.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                setthecompletetext();
                        
            }
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // three lines below are default
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
        setthecompletetext();
        // Make MenuInflater
        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu); //MENU.MENU DOESNT EXIST?
        inflater.inflate(R.menu.main, menu);
        SharedPreferences settings = getSharedPreferences("prefs", 0);
        //MENU//
        
        menu.add(1, 1, Menu.FIRST, "Settings");
        menu.add(1, 3, Menu.FIRST +2, "Feedback");
        menu.add(1, 4, Menu.FIRST +3, "About");
        
        
        boolean firstRun = settings.getBoolean("firstRun", true);
        //lol
        if ( firstRun ){
          settings.edit().putBoolean("firstRun", false).commit();
            AlertDialog.Builder ad = new AlertDialog.Builder(this);  
            ad.setTitle("Hey there new user!");  
            ad.setMessage("Change your text here \n \n Format is: \n Hi [their inputname], this is [your input for your name]. [[Text Body]]. [[Checkbox text if they toggled it]] \n \n Be sure to test it by sending the text to yourself first to see what its like.");
            		
            ad.setNegativeButton("OK", new DialogInterface.OnClickListener() {  
               public void onClick(DialogInterface dialog, int id) {  
                 dialog.dismiss(); 
            }  
            });  
            ad.show();
        }
    // Return True
    return true;
    }
    public void thanks() //toasts and takes you to the settings...
    {
        Context context = getApplicationContext();
        CharSequence text = "Text sent, thanks!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.CYAN);
        toast.show();
    }
    
    public void toasttester() //toasts and takes you to the settings...
    {
        Context context = getApplicationContext();
        CharSequence text = "Settings Menu";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.CYAN);
        toast.show();
        
        Intent in = new Intent(settingmenu.this, settingmenu.class);
        
        startActivity(in);
        setResult(Activity.RESULT_OK);
        
    }
    
    public void haspref(String key) //toasts and tells you if has preference
    {
        Context context = getApplicationContext();
        CharSequence text = "YUP CAN HAS MATCH";
        int duration = Toast.LENGTH_SHORT;
        
        if(sp.contains(key))
        {
        

        Toast toast = Toast.makeText(context, text, duration);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.CYAN);
        toast.show();
        }
        
    }
    public void clear() {

        EditText et = (EditText)findViewById(R.id.edit_name);
        EditText et2 = (EditText)findViewById(R.id.edit_number);
        et.setText("");
        et2.setText("");

    } 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) { //since int IDS are 1-4
            case 1:
                toasttester();
                return true;
            case 2: //clear
                clear();
                return true;
            case 3:
                toasttester();
                return true;
            case 4:
                haspref("intro");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
