import java.util.Scanner;

public class PrimeWithRecursive {
    public static void main(String[] args) {
        int number = 0; //null olarak bıraksaydım hata alacaktım.
        boolean errorCheck = true; //while'a girmesi için true

        Scanner input = new Scanner(System.in);

        //2 den küçük girdi istemediğim için while kullandım
        while (errorCheck) {
            if (number < 2) {
                System.out.print("Enter a possitive integer greater than 1: ");
                number = input.nextInt();
            } else {
                errorCheck = false;
            }
        }

        //bir sayının, 1den sonra kareköküne kadar olan tamsayılar
        //arasında (karekökü tamsayı çıkmayabilir! virgülden sonrasını keseceğiz)
        //tam böleni yok ise sayı asaldır!

        int divisorLimit = (int) Math.sqrt(number);//kökünün ondalıklı kısmını silerek bi değişkene attım.

        if (isPrime(number, divisorLimit)) {
            System.out.print(number + " is a prime number!");
        } else {
            System.out.print(number + " is not a prime number!");
        }
    }

    //fonksiyonu boolean tanımlamayı seçtim.
    //fonksiyonu tekrar çağırdığım satırda eğer işlemlerden birtanesi dahi false döndürürse
    //recursive'in yaptığım tüm işlem false dönmüş olacak!

    public static boolean isPrime(int number, int divisorLimit) {
        //divisorlimitin 1 veya 1den küçük olması sayının kendisine eriştiğimiz anlamına gelir
        //metodu çağırmaya devam etmemiz halinde
        //sonsuz bir döngü oluşacak!

        if (divisorLimit <= 1)
            return true;

        if (number % divisorLimit == 0)
            return false;
        return isPrime(number, divisorLimit - 1);
    }
}
