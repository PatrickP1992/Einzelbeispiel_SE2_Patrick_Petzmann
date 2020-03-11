package com.example.einzelbeispielse2;

public class AlternierendeQuersumme {
    private String input;
    private int ergebnis;
    private boolean istGerade;

    public AlternierendeQuersumme(String input) {
        this.input = input;
        this.ergebnis = 0;
        try {
            int number = Integer.parseInt(input);

        }
        catch(NumberFormatException e) {

        }

    }


    public int berechne()
    {
        char[] array = input.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (i%2==0)
            {
                ergebnis = ergebnis + ((int) array[i]);
            }
            else
            {
                ergebnis = ergebnis - ((int) array[i]);
            }
        }
        return ergebnis;
    }


    public boolean istGerade(int z)
    {
        if (z%2==0)
        {
            return true;
        }
        return false;
    }
}
