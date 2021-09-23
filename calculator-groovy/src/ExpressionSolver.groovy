////// #1
////def num1 = new Num(2)
////def num2 = new Num(3)
////def num3 = new Num(4)
////def num4 = new Num(2)
////def num5 = new Num(2)
////def expectedResult =21
////def str="${num1.getSize()}"+"+"+"${num2.getSize()}"+"+"+"${num3.getSize()}"+"*"+"${num4.getSize()}"+"**"+"${num5.getSize()}"
////assert (num1 + num2 + num3 * num4**num5).size == 21
////def res="The result of " + "${str}" + " is " + "${expectedResult}"
////def clos = {println "${res}"};
////clos.call();
//
//
//
//
//// #2
//def infixExpression = '7 + 10'
//def expectedResult2 = 17
//assert calculateInfix(infixExpression) == expectedResult2
//def res2 = "The result of " + "${infixExpression}" + " is " + "${expectedResult2}"
//def clos2 = {println "${res2}"}
//clos2.call()
//
//
////#3
//def infixExpression3 = '( 2 + 1 ) ^ 3 '
//def expectedResult3 = 27
//assert calculateInfix(infixExpression3) == expectedResult3
//def res3 = "The result of " + "${infixExpression3}" + " is " + "${expectedResult3}"
//def clos3 = {println "${res3}"}
//clos3.call()
//
////#4
//def infixExpression4 = ' 9223372036854775807 - 9223372036854775807 '
//def expectedResult4 = 0
//assert calculateInfix(infixExpression4) == expectedResult4
//def res4 = "The result of " + "${infixExpression4}" + " is " + "${expectedResult4}"
//def clos4 = {println "${res4}"}
//clos4.call()
//
////#5
//def infixExpression5 = '2 / 2 '
//def expectedResult5 = 1
//assert calculateInfix(infixExpression5) == expectedResult5
//def res5 = "The result of " + "${infixExpression5}" + " is " + "${expectedResult5}"
//def clos5 = {println "${res5}"}
//clos5.call()
//
////#6
//try {
//    def infixExpression6 = '2 / 0 '
//    def expectedResult6 = 0
//    assert calculateInfix(infixExpression6) == expectedResult6
//    def res6 = "The result of " + "${infixExpression6}" + " is " + "${expectedResult6}"
//    def clos6 = {println "${res6}"}
//    clos6.call()
//} catch (Exception e) {
//    println "Can't be divided by Zero"
//}
//
//
//def calculatePostfix(postfixExpression) throws Exception {
//    def stack = []
//    postfixExpression.split().each { token ->
//        if (token.isNumber()) {
//            stack.add(token)
//        } else {
//            def b1 = stack.pop().toBigDecimal()
//            def a1 = stack.pop().toBigDecimal()
//            def b=new Num()
//            b.setSize(b1)
//            def a=new Num()
//            a.setSize(a1)
//            stack.add(Operator.valueFrom(token).calculate(a, b))
//        }
//    }
//    stack.pop()
//
//}
//
//def calculateInfix(infixExpression) throws Exception {
//    calculatePostfix(ShuntingYardAlgorithm.convertToPostfix(infixExpression))
//}
