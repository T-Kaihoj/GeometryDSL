package executor

import syntaxTree._

object OperationExecutor
{
    def negation(x: Value): Value = x match
    {
        case IntValue(i) => IntValue(-i)
        case RealValue(r) => RealValue(-r)
        case _ => throw new Exception(s"Negation of ${x.getClass} is not supported")
    }

    def not(x: Value): Value = x match
    {
        case BoolValue(b) => BoolValue(!b)
        case _ => throw new Exception(s"Not of ${x.getClass} is not supported")
    }

    def cardinality(x: Value): Value = x match
    {
        case SetValue(s) => IntValue(s.size)
        case _ => throw new Exception(s"Cardinality of ${x.getClass} is not supported")
    }

    def add(left: Value, right: Value): Value = (left, right) match
    {
        case (IntValue(l), IntValue(r)) => IntValue(l + r)
        case (RealValue(l), RealValue(r)) => RealValue(l + r)
        case _ => throw new Exception(s"Addition of ${left.getClass} and ${right.getClass} is not supported")
    }

    def sub(left: Value, right: Value): Value = (left, right) match
    {
        case (IntValue(l), IntValue(r)) => IntValue(l - r)
        case (RealValue(l), RealValue(r)) => RealValue(l - r)
        case _ => throw new Exception(s"Subtraction of ${left.getClass} and ${right.getClass} is not supported")
    }

    def mul(left: Value, right: Value): Value = (left, right) match
    {
        case (IntValue(l), IntValue(r)) => IntValue(l * r)
        case (RealValue(l), RealValue(r)) => RealValue(l * r)
        case _ => throw new Exception(s"Multiplication of ${left.getClass} and ${right.getClass} is not supported")
    }

    def div(left: Value, right: Value): Value = (left, right) match
    {
        case (IntValue(l), IntValue(r)) => IntValue(l / r)
        case (RealValue(l), RealValue(r)) => RealValue(l / r)
        case _ => throw new Exception(s"Division of ${left.getClass} and ${right.getClass} is not supported")
    }

    def pow(left: Value, right: Value): Value =
    {
        lazy val intPow: (Long, Long) => Long =
            (l: Long, r: Long) => r match
            {
                case 0 => 1
                case _ => l * intPow(l, r - 1)
            }

        lazy val doublePow: (Double, Long) => Double =
            (l: Double, r: Long) => r match
            {
                case 0 => 1.0
                case _ => l * doublePow(l, r - 1)
            }

        (left, right) match
        {
            case (IntValue(l), IntValue(r)) => IntValue(intPow(l, r))
            case (RealValue(l), IntValue(r)) => RealValue(doublePow(l, r))
            case _ => throw new Exception(s"Power of ${left.getClass} and ${right.getClass} is not supported")
        }
    }

    def equal(left: Value, right: Value): Value = (left, right) match
    {
        case (BoolValue(l), BoolValue(r)) => BoolValue(l == r)
        case (IntValue(l), IntValue(r)) => BoolValue(l == r)
        case (RealValue(l), RealValue(r)) => BoolValue(l == r)
        case _ => throw new Exception(s"Equal of ${left.getClass} and ${right.getClass} is not supported")
    }

    def notEqual(left: Value, right: Value): Value = (left, right) match
    {
        case (BoolValue(l), BoolValue(r)) => BoolValue(l != r)
        case (IntValue(l), IntValue(r)) => BoolValue(l != r)
        case (RealValue(l), RealValue(r)) => BoolValue(l != r)
        case _ => throw new Exception(s"NotEqual of ${left.getClass} and ${right.getClass} is not supported")
    }

    def lessThan(left: Value, right: Value): Value = (left, right) match
    {
        case (BoolValue(l), BoolValue(r)) => BoolValue(l < r)
        case (IntValue(l), IntValue(r)) => BoolValue(l < r)
        case (RealValue(l), RealValue(r)) => BoolValue(l < r)
        case _ => throw new Exception(s"LessThan of ${left.getClass} and ${right.getClass} is not supported")
    }

    def lessThanEqual(left: Value, right: Value): Value = (left, right) match
    {
        case (BoolValue(l), BoolValue(r)) => BoolValue(l <= r)
        case (IntValue(l), IntValue(r)) => BoolValue(l <= r)
        case (RealValue(l), RealValue(r)) => BoolValue(l <= r)
        case _ => throw new Exception(s"LessThanEqual of ${left.getClass} and ${right.getClass} is not supported")
    }

    def greaterThan(left: Value, right: Value): Value = (left, right) match
    {
        case (BoolValue(l), BoolValue(r)) => BoolValue(l > r)
        case (IntValue(l), IntValue(r)) => BoolValue(l > r)
        case (RealValue(l), RealValue(r)) => BoolValue(l > r)
        case _ => throw new Exception(s"GreaterThan of ${left.getClass} and ${right.getClass} is not supported")
    }

    def greaterThanEqual(left: Value, right: Value): Value = (left, right) match
    {
        case (BoolValue(l), BoolValue(r)) => BoolValue(l >= r)
        case (IntValue(l), IntValue(r)) => BoolValue(l >= r)
        case (RealValue(l), RealValue(r)) => BoolValue(l >= r)
        case _ => throw new Exception(s"GreaterThanEqual of ${left.getClass} and ${right.getClass} is not supported")
    }

    def and(left: Value, right: Value): Value = (left, right) match
    {
        case (BoolValue(l), BoolValue(r)) => BoolValue(l && r)
        case _ => throw new Exception(s"And of ${left.getClass} and ${right.getClass} is not supported")
    }

    def or(left: Value, right: Value): Value = (left, right) match
    {
        case (BoolValue(l), BoolValue(r)) => BoolValue(l || r)
        case _ => throw new Exception(s"Or of ${left.getClass} and ${right.getClass} is not supported")
    }

    def implies(left: Value, right: Value): Value = (left, right) match
    {
        case (BoolValue(l), BoolValue(r)) => BoolValue(!l || r)
        case _ => throw new Exception(s"Implies of ${left.getClass} and ${right.getClass} is not supported")
    }

    def union(left: Value, right: Value): Value = (left, right) match
    {
        case (SetValue(l), SetValue(r)) => SetValue(l.union(r))
        case _ => throw new Exception(s"Union of ${left.getClass} and ${right.getClass} is not supported")
    }

    def intersect(left: Value, right: Value): Value = (left, right) match
    {
        case (SetValue(l), SetValue(r)) => SetValue(l.intersect(r))
        case _ => throw new Exception(s"Intersect of ${left.getClass} and ${right.getClass} is not supported")
    }

    def difference(left: Value, right: Value): Value = (left, right) match
    {
        case (SetValue(l), SetValue(r)) => SetValue(l.diff(r))
        case _ => throw new Exception(s"Difference of ${left.getClass} and ${right.getClass} is not supported")
    }

    def subset(left: Value, right: Value): Value = (left, right) match
    {
        case (SetValue(l), SetValue(r)) => BoolValue(l.subsetOf(r))
        case _ => throw new Exception(s"Subset of ${left.getClass} and ${right.getClass} is not supported")
    }

    def propSubset(left: Value, right: Value): Value = (left, right) match
    {
        case _ => throw new Exception(s"ProperSubset of ${left.getClass} and ${right.getClass} is not supported")
    }

    def inSet(left: Value, right: Value): Value = (left, right) match
    {
        case _ => throw new Exception(s"InSet of ${left.getClass} and ${right.getClass} is not supported")
    }
}