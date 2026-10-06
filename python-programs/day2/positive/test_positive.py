from PositiveNo import PositiveNo

def ispositive_10():
      assert PositiveNo(10)==True

def ispositive_0():
      assert PositiveNo(0)==False

def ispositive_2():
      assert PositiveNo(-2)==False

def ispositive_float():
      assert PositiveNo(1.2)==True

def ispositive_float():
      assert PositiveNo(0.1)==True

def ispositive_neg_float():
      assert PositiveNo(-0.1)==False


