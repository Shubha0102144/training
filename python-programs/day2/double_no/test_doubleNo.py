from DoubleNo import DoubleNo

def double_of_2():
      assert DoubleNo(2)==4

def double_of_0():
      assert DoubleNo(0)==0

def double_of_8():
      assert DoubleNo(4)==8

def double_of_n2():
      assert DoubleNo(-2)==-4

def double_of_float():
      assert DoubleNo(1.5)==3

def double_of_string():
      assert DoubleNo("abc")=="abcabc"

def double_of_float():
      assert DoubleNo(0.1)==0.2

def double_of_a():
      assert DoubleNo('a')=='aa'

