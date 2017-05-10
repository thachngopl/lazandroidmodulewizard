package com.example.appautocompletetextviewdemo1;

import java.util.ArrayList;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.view.Gravity;

/*Draft java code by "Lazarus Android Module Wizard" [4/21/2016 19:42:01]*/
/*https://github.com/jmpessoa/lazandroidmodulewizard*/
/*jVisualControl template*/

public class jAutoTextView extends AutoCompleteTextView /*dummy*/ { //please, fix what GUI object will be extended!

   private Controls   controls  = null; // Control Class for events
   private jCommons LAMWCommon;

   private Context context = null;
   private ViewGroup parent   = null;         // parent view
 
   private OnClickListener onClickListener;   // click event

   private Boolean enabled  = true;           // click-touch enabled!

   ArrayList<String> mStrList;
   ArrayAdapter<String> mAdapter;

   float mTextSize = 0; //default
   int mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_SP; //default

   private ClipboardManager mClipBoard = null;
   private ClipData mClipData = null;

   //GUIDELINE: please, preferentially, init all yours params names with "_", ex: int _flag, String _hello ...

   public jAutoTextView(Controls _ctrls, long _Self) { //Add more others news "_xxx"p arams if needed!
      super(_ctrls.activity);
      context   = _ctrls.activity;
      controls  = _ctrls;
      
      LAMWCommon = new jCommons(this,context,_Self);

      mStrList = new ArrayList<String>();
      mAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,mStrList);
      this.setAdapter(mAdapter);
      this.setThreshold(1);

      mClipBoard = (ClipboardManager) controls.activity.getSystemService(Context.CLIPBOARD_SERVICE);

      onClickListener = new OnClickListener(){
         /*.*/public void onClick(View view){  //please, do not remove /*.*/ mask for parse invisibility!
            if (enabled) {
               controls.pOnClickGeneric(LAMWCommon.getPasObj(), Const.Click_Default); //JNI event onClick!
            }
         };
      };
      setOnClickListener(onClickListener);

      // when the user clicks an item of the drop-down list
      this.setOnItemClickListener(new OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                	  /*
                       Toast.makeText(getBaseContext(), "MultiAutoComplete: " +
                                  "you add color "+arg0.getItemAtPosition(arg2), //mStrList.get((int)arg3)
                                  Toast.LENGTH_LONG).show();
                       */
            controls.pOnClickAutoDropDownItem(LAMWCommon.getPasObj(), (int)arg3, arg0.getItemAtPosition(arg2).toString());
         }
      });

   } //end constructor

   public void jFree() {
      if (parent != null) { parent.removeView(this); }
      //free local objects...
      setOnClickListener(null);
      LAMWCommon.free();
   }

	public long GetPasObj() {
		return LAMWCommon.getPasObj();
	}

	public  void SetViewParent(ViewGroup _viewgroup ) {
		LAMWCommon.setParent(_viewgroup);
	}
	
	public ViewGroup GetParent() {
		return LAMWCommon.getParent();
	}
	
	public void RemoveFromViewParent() {
		LAMWCommon.removeFromViewParent();
	}

	public void SetLeftTopRightBottomWidthHeight(int left, int top, int right, int bottom, int w, int h) {
		LAMWCommon.setLeftTopRightBottomWidthHeight(left,top,right,bottom,w,h);
	}
		
	public void SetLParamWidth(int w) {
		LAMWCommon.setLParamWidth(w);
	}

	public void SetLParamHeight(int h) {
		LAMWCommon.setLParamHeight(h);
	}
    
	public int GetLParamHeight() {
		return  LAMWCommon.getLParamHeight();
	}

	public int GetLParamWidth() {				
		return LAMWCommon.getLParamWidth();					
	}  

	public void SetLGravity(int _g) {
		LAMWCommon.setLGravity(_g);
	}

	public void SetLWeight(float _w) {
		LAMWCommon.setLWeight(_w);
	}

	public void AddLParamsAnchorRule(int rule) {
		LAMWCommon.addLParamsAnchorRule(rule);
	}
	
	public void AddLParamsParentRule(int rule) {
		LAMWCommon.addLParamsParentRule(rule);
	}

	public void SetLayoutAll(int idAnchor) {
		LAMWCommon.setLayoutAll(idAnchor);
	}
	
	public void ClearLayoutAll() {		
		LAMWCommon.clearLayoutAll();
	}
	
   public View GetView() {
      return this;
   }
   
   public void SetId(int _id) { //wrapper method pattern ...
      this.setId(_id);
   }

   //write others [public] methods code here......
   //GUIDELINE: please, preferentially, init all yours params names with "_", ex: int _flag, String _hello ...

   //getAdapter()
   //This method returns a filterable list adapter used for auto completion

   //This method returns optional hint text displayed at the bottom of the the matching list
   /*
   public String GetCompletionHint() {
	   return (String)this.getCompletionHint();
   }
   */

   //This method returns returns the id for the view that the auto-complete drop down list is anchored to.
   /*
   public int GetDropDownAnchor() {
	   return this.getDropDownAnchor();
   }
   */

   //This method returns the position of the dropdown view selection, if there is one
   public int GetItemIndex() {
      return this.getListSelection();
   }

   //This method indicates whether the popup menu is showing
   /*
   public boolean IsPopupShowing() {
		return this.isPopupShowing();
   }
    */

   public void SetText(String _text) {
      this.setText(_text);
   }

   public String GetText() {
      return this.getText().toString();
   }

   public void Clear() {
      this.setText("");
   }

   //This method displays the drop down on screen.
   public void	ShowDropDown(){
      this.showDropDown();
   }

   public void SetThreshold(int _threshold) {
      this.setThreshold(_threshold);
   }

   public void Add(String _text) {
      mStrList.add(_text);
      mAdapter.notifyDataSetChanged();
   }

   public int CountDropDown() {
      return mStrList.size();
   }

   public void ClearAll() {
      this.setText("");
      mStrList.clear();
      mAdapter.notifyDataSetChanged();
   }

   public void ClearDropDown() {
      mStrList.clear();
      mAdapter.notifyDataSetChanged();
   }

   public  void SetTextAlignment( int align ) {
      switch ( align ) {
         case 0 : { setGravity( Gravity.START              ); }; break;
         case 1 : { setGravity( Gravity.END             ); }; break;
         case 2 : { setGravity( Gravity.TOP               ); }; break;
         case 3 : { setGravity( Gravity.BOTTOM            ); }; break;
         case 4 : { setGravity( Gravity.CENTER            ); }; break;
         case 5 : { setGravity( Gravity.CENTER_HORIZONTAL ); }; break;
         case 6 : { setGravity( Gravity.CENTER_VERTICAL   ); }; break;
         default : { setGravity( Gravity.START              ); }; break;
      };
   }

   public void CopyToClipboard() {
      mClipData = ClipData.newPlainText("text", this.getText().toString());
      mClipBoard.setPrimaryClip(mClipData);
   }

   public void PasteFromClipboard() {
      ClipData cdata = mClipBoard.getPrimaryClip();
      ClipData.Item item = cdata.getItemAt(0);
      this.setText(item.getText().toString());
   }

   public void Append(String _text) {
      this.append( _text);
   }

   public void AppendLn(String _text) {
      this.append( _text+ "\n");
   }

   public void AppendTab() {
      this.append("\t");
   }

   public void SetFontAndTextTypeFace(int _fontFace, int _fontStyle) {
      Typeface t = null;
      switch (_fontFace) {
         case 0: t = Typeface.DEFAULT; break;
         case 1: t = Typeface.SANS_SERIF; break;
         case 2: t = Typeface.SERIF; break;
         case 3: t = Typeface.MONOSPACE; break;
      }
      this.setTypeface(t, _fontStyle);
   }

   public void SetTextSize(float _size) {
      mTextSize = _size;
      String t = this.getText().toString();
      this.setTextSize(mTextSizeTypedValue, mTextSize);
      this.setText(t);
   }

   //TTextSizeTypedValue =(tsDefault, tsPixels, tsDIP,tsMillimeters, tsPoints, tsScaledPixel);
   public void SetFontSizeUnit(int _unit) {
      switch (_unit) {
         case 0: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_SP; break; //default
         case 1: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_PX; break; 
         case 2: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_DIP; break;
         case 3: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_MM; break; 
         case 4: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_PT; break; 
         case 5: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_SP; break; 
      }
      String t = this.getText().toString();
      this.setTextSize(mTextSizeTypedValue, mTextSize);
      this.setText(t);
   }
   
	@Override
	protected void dispatchDraw(Canvas canvas) {	 	
	    //DO YOUR DRAWING ON UNDER THIS VIEWS CHILDREN
		controls.pOnBeforeDispatchDraw(LAMWCommon.getPasObj(), canvas, 1);  //event handle by pascal side		
	    super.dispatchDraw(canvas);	    
	    //DO YOUR DRAWING ON TOP OF THIS VIEWS CHILDREN
	    controls.pOnAfterDispatchDraw(LAMWCommon.getPasObj(), canvas, 1);	 //event handle by pascal side    
	}   

} //end class

//TODO: MultiAutoCompleteTextView

