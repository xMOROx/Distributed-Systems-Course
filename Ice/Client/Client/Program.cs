using System;
using Ice;
using IceGrid;
using Operations;

public class Client
{
    public static void Main(string[] args)
    {
        int status = 0;
        try
        {
            using (Ice.Communicator ic = Ice.Util.initialize(ref args))
            {
                Ice.ObjectPrx obj = ic.stringToProxy("calc/calc1:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z");

                do
                {


                    try
                    {
                        String input = "";
                        Console.WriteLine("Enter the operation to be performed: ");
                        input = Console.ReadLine();

                        switch (input.Trim())
                        {
                            case "divide2":
                                {
                                    double x = 100, y = 0;

                                    Ice.OutputStream outStream = new Ice.OutputStream(ic);
                                    outStream.startEncapsulation();
                                    outStream.writeDouble(x);
                                    outStream.writeDouble(y);
                                    outStream.endEncapsulation();
                                    byte[] inParams = outStream.finished();
                                    byte[] outParams;
                                    if (obj.ice_invoke("divide", Ice.OperationMode.Idempotent, inParams, out outParams))
                                    {
                                        Ice.InputStream inStream = new Ice.InputStream(ic, outParams);
                                        inStream.startEncapsulation();
                                        double result = inStream.readDouble();
                                        inStream.endEncapsulation();
                                        System.Console.WriteLine("Result: " + result);
                                    }
                                    break;
                                }

                            case "averageSalary":
                                {
                                    Person p1 = new Person();
                                    p1.name = "John";
                                    p1.salary = 120;
                                    p1.email = "test@gmail.com";
                                    Person p2 = new Person();
                                    p2.name = "Doe";
                                    p2.salary = 200;
                                    p2.email = "test@gmail.com";
                                    Person p3 = new Person();
                                    p3.name = "Jane";
                                    p3.salary = 300;
                                    p3.email = "test@gmail.com";
                                    Person[] persons = new Person[] { p1, p2, p3 };

                                    Ice.OutputStream outStream = new Ice.OutputStream(ic);
                                    outStream.startEncapsulation();
                                    PersonListHelper.write(outStream, persons);
                                    outStream.endEncapsulation();
                                    byte[] inParams = outStream.finished();
                                    byte[] outParams;

                                    if (obj.ice_invoke("averageSalary", Ice.OperationMode.Idempotent, inParams, out outParams))
                                    {
                                        Ice.InputStream inStream = new Ice.InputStream(ic, outParams);
                                        inStream.startEncapsulation();
                                        double result = inStream.readDouble();
                                        inStream.endEncapsulation();
                                        System.Console.WriteLine("Result: " + result);
                                    }

                                    break;
                                }
                            default:
                                {

                                    double x = 100, y = 10;

                                    Ice.OutputStream outStream = new Ice.OutputStream(ic);
                                    outStream.startEncapsulation();
                                    outStream.writeDouble(x);
                                    outStream.writeDouble(y);
                                    outStream.endEncapsulation();
                                    byte[] inParams = outStream.finished();
                                    byte[] outParams;

                                    if (obj.ice_invoke(input.Trim(), Ice.OperationMode.Idempotent, inParams, out outParams))
                                    {


                                        Ice.InputStream inStream = new Ice.InputStream(ic, outParams);

                                        inStream.startEncapsulation();
                                        double result = inStream.readDouble();
                                        inStream.endEncapsulation();
                                        System.Console.WriteLine("Result: " + result);
                                    }
                                    break;
                                }
                        }

                    }
                    catch (Ice.LocalException _ex)
                    {
                        Console.WriteLine("Operation does not exist");
                        status = 1;
                    }
                    catch (Ice.UserException _ex)
                    {
                        Console.WriteLine("Error in operation because of user input");
                        Console.WriteLine(_ex);
                        status = 1;
                    }
                    catch (System.FormatException _ex)
                    {
                        Console.WriteLine("Invalid input");
                        status = 1;
                    }
                    catch (System.Exception _ex)
                    {
                        Console.WriteLine("Error in operation");
                        Console.WriteLine(_ex);
                        status = 1;
                    }

                } while (true);


            }
        }
        catch (Ice.Exception e)
        {
            Console.Error.WriteLine(e);
            status = 1;
        }
        Environment.Exit(status);
    }
}
