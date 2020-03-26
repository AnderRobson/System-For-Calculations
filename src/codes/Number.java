package codes;

public class Number {

    /** Valor a ser inserido pelo usuário.*/
    private int value;

    /**
     * Método construtor.
     *
     * @param value
     */
    public Number (int value) {
        this.value = value;
    }

    /**
     * Pegando valor da variável da class.
     */
    public int getValue () {
        return this.value;
    }

    /**
     * Setando valor na variável da classe.
     *
     * @param value
     */
    public void setValue (int value) {
        this.value = value;
    }

    /**
     * Calculando fatorial.
     *
     * @return int
     */
    public int calculateFactorial () {
        int count = 1;
        int factorial = 1;

        do {
            factorial *= count;
            count++;
        } while (count <= this.value);

        return factorial;
    }

    /**
     * Calculando soma.
     *
     * @return int
     */
    public int calculateSum () {
        int sum = 0;
        int count = 1;

        do {
            sum += count;
            count++;
        } while (count <= this.value);

        return sum;
    }

    /**
     * Calculando múltiplos.
     *
     * @return int
     */
    public int calculateMultiples () {
        int countMultiples = 0;
        int count = 1;

        do {
            if (this.value % count == 0) {
                countMultiples++;
            }

            count++;
        } while (count <= this.value);

        return countMultiples;
    }

    /**
     * Verificando se e número é Primo ou Composto.
     *
     * @return String
     */
    public String verifyIfAndCousin () {
        int countMultiples = this.calculateMultiples();

        if (countMultiples == 2) {
            return this.getValue() + " é Primo.";
        }

        return this.getValue() + " é Composto.";
    }
}
