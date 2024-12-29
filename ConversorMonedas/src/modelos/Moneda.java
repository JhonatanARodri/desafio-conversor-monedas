package modelos;

public enum Moneda {
    ARS("Pesos argentinos", "$"),
    BOB("Bolivianos", "Bs"),
    BRL("Reales brasileños", "R$"),
    CLP("Pesos chilenos", "$"),
    COP("Pesos colombianos", "COL$"),
    USD("Dólares estadounidenses", "$");

    private final String nombre;
    private final String simbolo;

    Moneda(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public static Moneda porIndice (int indice) {
        if (indice < 0 || indice >= values().length ) {
            throw new IllegalArgumentException("Indicie Invalido");
        }
        return values()[indice];
    }
}
