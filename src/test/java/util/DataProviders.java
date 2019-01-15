package util;

import org.testng.annotations.DataProvider;
import pages.PageBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviders {
    @DataProvider
    public static Iterator<Object[]> loginPositive() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/LoginPositive.data")));//считывает значения email & password
        List<Object[]> userData = new ArrayList<>();//массив email & password

        for(String line = in.readLine(); line != null; line = in.readLine()) {
            userData.add(line.split(";")); //разделитель email & password
        }

        in.close();
        return userData.iterator();
    }


    @DataProvider
    public static Iterator<Object[]> loginNegative() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/LoginNegative.data")));//считывает значения email & password
        List<Object[]> userData = new ArrayList<>();//массив email & password

        for(String line = in.readLine(); line != null; line = in.readLine()) {
            userData.add(line.split(";")); //разделитель email & password
        }

        in.close();
        return userData.iterator();
    }



    @DataProvider
    public static Iterator<Object[]> anotherPositiveLogin() { // метод как и первый,но email & password ввщдится здесь
        List<Object[]> data = new ArrayList();
        data.add(new Object[]{"jmenka@gmail.com", "221263"});
        data.add(new Object[]{"jmenkaLongLongLong@gmail.com", "jmenkaLongLongLong@gmail.com"});
        data.add(new Object[]{"Jenya@gmail.com", "example"});

        return data.iterator();
    }

    @DataProvider// генерация рандомного email & password
    public Iterator<Object[]> randomUsers() { //итерирует группу значений
        List<Object[]> data = new ArrayList();

        for(int i = 0; i < 1; ++i) {
            data.add(new Object[]{this.generateRandomName(), this.generateRandomPassword()});
        }

        return data.iterator();
    }

    private Object generateRandomPassword() {
        return "pass" + (new Random()).nextInt();
    }

    //private Object generateRandomName() { return "demo" + (new Random()).nextInt()+"@gmail.com"; }

    private Object generateRandomName() { return PageBase.latinDigitString(10)+"@gmail.com"; }
}
