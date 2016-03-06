package de.luisfernandoalvarez.nvramax1030;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;


import java.io.*;public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
	public void onCopiarButtonClick(View view) 
    {
    	// This Java code shows a toast
		try {
			Runtime.getRuntime().exec("su -c dd if=/dev/block/mmcblk0p2 of=/sdcard/nvram-ax1030.img count=1 bs=5242880");
		} catch (IOException e) {
		} 
    	Toast.makeText(this, "Copiado a /sdcard/nvram-ax1030.img con éxito", Toast.LENGTH_SHORT).show();
	}
	
	public void onRestaurarButtonClick(View view) 
    {
    	// This Java code shows a toast
		try {
			Runtime.getRuntime().exec("su -c dd if=/sdcard/nvram-ax1030.img of=/dev/block/mmcblk0p2");
		} catch (IOException e) {
		} 
    	Toast.makeText(this, "Restaurado desde /sdcard/nvram-ax1030.img con éxito", Toast.LENGTH_SHORT).show();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate main_menu.xml 
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.mainMenuAcerca:
				Toast.makeText(this, "Desarrollador: Luis Fernando Alvarez Yanes", Toast.LENGTH_LONG).show();
				Toast.makeText(this, "Guatemala, marzo de 2016", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.mainMenuReiniciar:
				try {
					Runtime.getRuntime().exec("su -c reboot");
				} catch (IOException e) {
				}
				return true;
			case R.id.mainMenuSalir:
				Toast.makeText(this, "¡Gracias por usar mis proyectos!", Toast.LENGTH_LONG).show();
				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
