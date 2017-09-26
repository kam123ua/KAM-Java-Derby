package Core;

import java.io.FileNotFoundException;

public class Language {
	
	public static String instruction,mes_emp,dl_basa,export,name_of_table,dl_tab,insert,to,update,delete,succes,okno_cr,okno_op,okno_st,okno_exit,okno_av,okno_chang,cr_name,cr_but,tb_n,tb_1,tb_2,tb_3,sv,table;
	
	public static void Lang(){
		try {
			String lang=Metod.Read("language.lang");
			
			if(lang.length()==4){
				okno_cr="Створити базу даних";
				okno_st="Сайт програми";
				okno_op="Відкрити базу даних";
				okno_exit="Вийти";
				okno_av="Автор: К.А.М.";
				okno_chang="Змінити мову";
				cr_name="Ім'я бази даних:";
				tb_n="Вибрати таблицю:";
				tb_1="Переглянути";
				tb_2="Пошук";
				tb_3="Створити таблицю";
				sv="Зберегти";
				table="Таблиці";
				delete="Видалити";
				to="до";
				update="Оновити";
				insert="Додати";
				dl_tab="Видалити таблицю";
				name_of_table="Ім'я таблиці:";
				dl_basa="Видалити базу";
				mes_emp="Введіть ім'я!";
				instruction="Інструкція";
			}
			
			if(lang.length()==3){
				okno_cr="Create a database";
				okno_st="Site of program";
				okno_op="Open database";
				okno_exit="Exit";
				okno_av="Author: K.A.M";
				okno_chang="Change the language";
				cr_name="Database name:";
				tb_n="Choose table:";
				tb_1="Review";
				tb_2="Search";
				tb_3="Create a table";
				sv="Save";
				table="Table";
				delete="Delete";
				to="to";
				update="Update";
				insert="Insert";
				dl_tab="Remove table";
				name_of_table="Name of table:";
				dl_basa="Delete database";
				mes_emp="Enter the name!";
				instruction="Instruction";
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
