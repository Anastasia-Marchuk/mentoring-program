class ShuntingYardAlgorithm {
    def static convertToPostfix(infixExpression) {
        def output = []
        def stack = []

        infixExpression?.split().each { token ->
            processToken(token, output, stack)
        }
        while (!stack.isEmpty()) {
            output.add stack.pop()
        }
        output.join(' ')
    }
    def static processToken(token, output, stack) {
        if (token.isNumber()) {
            output.add token
        } else {
            switch (token) {
                case "(":
                    stack.add token
                    break
                case ")":
                    while (stack.last() != "(") {
                        output.add stack.pop()
                    }
                    stack.pop()
                    break
                default:
                    def operator = Operator.valueFrom(token)
                    while (!stack.isEmpty() &&
                            stack.last().is(Operator) &&
                            operator <= stack.last()) {
                        output.add stack.pop()
                    }
                    stack.add operator
            }
        }
    }
}