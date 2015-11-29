
import java.util.Scanner;

/**
 *
 * @author Eren Çetinkaya Cruz
 */
public class MukemmelSayi {

 public static void main(String[] args) {
  // TODO Auto-generated method stub

  Scanner cr = new Scanner(System.in);
  
  int sayi;
  System.out.println("Bir sayi giriniz : ");
  sayi = cr.nextInt();  
  
  //kontrol edilecek sayıyı fonksiyonumuza yolluyoruz 
  if(mukemmelSayiBul(sayi)){
   System.out.println(sayi+" sayısı mükemmel sayıdır.");
  }else{
   System.out.println(sayi+" sayısı mükemmel sayı değildir.");
  }
   
  
 }
 
 public static boolean mukemmelSayiBul(int sayi) {
  
  // kendisinden küçük tüm sayılara bölüyoruz ve tam bölen sayıları topluyoruz
  int toplam = 0;
  for (int i = 1; i < sayi; i++) {
   if (sayi % i == 0) {
    toplam += i;
   }
  }
  //toplam, sayımıza eşit ise mükemmel sayı olmuş oluyor 
  if (toplam == sayi) {
   return true;
  } else {
   return false;
  }
 }

}
