enum Operator {

    PLUS('+', 0, { a, b -> a?.getSize()+b?.getSize() }),
    MINUS('-', 0, { a, b -> a?.getSize()-b?.getSize() }),
    MULTIPLY('*', 1, { a, b -> a?.getSize()*b?.getSize()  }),
    DIVIDE('/', 1, { a, b -> a?.getSize()/b?.getSize() }),
    EXP('^', 1, { a, b -> a?.getSize()**b?.getSize() })


    String value
    int precedence
    Closure calculate

    private Operator(String value, int precedence, Closure calculate) {
        this.value = value
        this.precedence = precedence
        this.calculate = calculate
    }

    def static valueFrom(string) {
        for (operator in Operator.values()) {
            if (operator.value == string) {
                return operator
            }
        }
        throw new IllegalArgumentException("invalid operator ${string}")
    }

    def int compareTo(other) {
        precedence <=> other.precedence
    }
    def String toString() {
        value
    }
}