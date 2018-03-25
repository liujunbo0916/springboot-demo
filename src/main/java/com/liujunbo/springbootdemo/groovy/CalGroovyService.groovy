package com.liujunbo.springbootdemo.groovy

class CalGroovyService {

    def static mpSort(){
        def sortAry = [23,43,1,22,67,2,6]

        for (def i = 0; i <sortAry.size() ; i++) {

            for (def j = 1; j <sortAry.size()-i-1 ; j++) {
                if (sortAry[j-1]>sortAry[j]){
                    def temp = sortAry[j]
                    sortAry[j] = sortAry[j-1]
                    sortAry[j-1] = temp
                }
            }
            return sortAry
        }
    }


    def static closure = {
        param -> print param
    }

     static void main(String[] args) {
         closure 'hello'
    }


}
