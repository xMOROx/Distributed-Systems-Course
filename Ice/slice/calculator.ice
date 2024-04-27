#ifndef CALC_ICE
#define CALC_ICE

module Operations
{
    exception DivisionByZero {
        string reason;
    };

        struct Person {
            string name;
            string email;
            double salary;
        };

    sequence<Person> PersonList;



  interface Calc
  {
    idempotent long add(double a, double b);
    idempotent long subtract(double a, double b);
    idempotent long multiply(double a, double b);
    idempotent long divide(double a, double b) throws DivisionByZero;
    idempotent long averageSalary(PersonList persons);
  };

};

#endif

