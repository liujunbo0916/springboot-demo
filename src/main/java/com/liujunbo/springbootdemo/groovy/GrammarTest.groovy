package com.liujunbo.springbootdemo.groovy


    def value = 1
    value = value + 1
    println(value)

   def m = 5
   def j = 2
   print  12*m /j

  def  age = 25
  println "My age is ${age}"
println 'My age is ${age}'
println """My age is ${age} """
println "My age is \${age}"

  def greeting  = 'hello word'
  println  greeting - 'o word'
  println greeting.size()
  println greeting.count('o')
  println greeting.intern()
  println greeting.center(20)
  println greeting.center(20,'@')

 def list1 = [34,65,76,87,1,2,3]
 def list2 = list1.getAt([2,3,5,6]) //返回 列表索引对应值的列表
 def list3 = list1.getAt(1..3);
 print list2
 print list3
 def map1 = [4:[2],5:[3,4],6:[7,8]]
println map1[5]














