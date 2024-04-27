package pl.zajdel.patryk.Calculator;

import com.zeroc.Ice.*;
import com.zeroc.IceInternal.Incoming;
import pl.zajdel.patryk.generated.Operations.DivisionByZero;
import pl.zajdel.patryk.generated.Operations.Person;
import pl.zajdel.patryk.generated.Operations.PersonListHelper;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;

public class CalcImpl implements Blobject {

    private static Ice_invokeResult performAction(Consumer<OutputStream> action, Current current) {
        Communicator communicator = current.adapter.getCommunicator();
        OutputStream out = new OutputStream(communicator);
        Ice_invokeResult result = new Ice_invokeResult();


        out.startEncapsulation();
        action.accept(out);
        out.endEncapsulation();
        result.outParams = out.finished();
        result.returnValue = true;
        return result;
    }

    @Override
    public Ice_invokeResult ice_invoke(byte[] bytes, Current current) throws UserException {
        Communicator communicator = current.adapter.getCommunicator();
        InputStream in = new InputStream(communicator, bytes);
        switch (current.operation) {
            case "add": {
                in.startEncapsulation();
                double a = in.readDouble();
                double b = in.readDouble();
                in.endEncapsulation();
                System.out.println("Adding " + a + " and " + b);

                return performAction(o -> o.writeDouble(a + b), current);
            }
            case "subtract": {
                in.startEncapsulation();
                double a = in.readDouble();
                double b = in.readDouble();
                in.endEncapsulation();

                System.out.println("Subtracting " + a + " and " + b);

                return performAction(o -> o.writeDouble(a - b), current);
            }

            case "multiply": {
                in.startEncapsulation();
                double a = in.readDouble();
                double b = in.readDouble();
                in.endEncapsulation();
                System.out.println("Multiplying " + a + " and " + b);

                return performAction(o -> o.writeDouble(a * b), current);
            }
            case "divide": {
                in.startEncapsulation();
                double a = in.readDouble();
                double b = in.readDouble();
                in.endEncapsulation();
                if (b == 0) {
                    DivisionByZero ex = new DivisionByZero("The value b is equal to zero!");
                    OutputStream out = new OutputStream(communicator);
                    Ice_invokeResult result = new Ice_invokeResult();
                    out.startEncapsulation();
                    out.writeException(ex);
                    out.endEncapsulation();
                    result.outParams = out.finished();
                    result.returnValue = false;

                }

                System.out.println("Dividing " + a + " and " + b);

                return performAction(o -> o.writeDouble(a / b), current);
            }
            case "averageSalary": {
                in.startEncapsulation();
                Person[] persons = PersonListHelper.read(in);
                in.endEncapsulation();

                double sum = 0;
                for (Person p : persons) {
                    sum += p.salary;
                }
                double _sum = sum;


                return performAction(o -> o.writeDouble(_sum / persons.length), current);
            }
            default:
                OperationNotExistException ex = new OperationNotExistException();
                ex.id = current.id;
                ex.facet = current.facet;
                ex.operation = current.operation;
                throw ex;
        }
    }

    @Override
    public CompletionStage<OutputStream> _iceDispatch(Incoming in, Current current) throws UserException {
        return Blobject.super._iceDispatch(in, current);
    }

    @Override
    public boolean ice_isA(String s, Current current) {
        return Blobject.super.ice_isA(s, current);
    }

    @Override
    public void ice_ping(Current current) {
        Blobject.super.ice_ping(current);
    }

    @Override
    public String[] ice_ids(Current current) {
        return Blobject.super.ice_ids(current);
    }

    @Override
    public String ice_id(Current current) {
        return Blobject.super.ice_id(current);
    }

    @Override
    public CompletionStage<OutputStream> ice_dispatch(Request request) throws UserException {
        return Blobject.super.ice_dispatch(request);
    }

    @Override
    public void _iceWrite(OutputStream ostr) {
        Blobject.super._iceWrite(ostr);
    }

    @Override
    public void _iceWriteImpl(OutputStream ostr) {
        Blobject.super._iceWriteImpl(ostr);
    }

    @Override
    public void _iceRead(InputStream istr) {
        Blobject.super._iceRead(istr);
    }

    @Override
    public void _iceReadImpl(InputStream istr) {
        Blobject.super._iceReadImpl(istr);
    }


}
