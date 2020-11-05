package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService ops;

	public ContractService(OnlinePaymentService ops) {
		this.setOps(ops);
	}

	public OnlinePaymentService getOps() {
		return ops;
	}

	public void setOps(OnlinePaymentService ops) {
		this.ops = ops;
	}
	
	public void processContract(Contract contract, int months) {
		double firstQuota = contract.getTotalValue() / months;
		for(int i = 1; i<=months; i++) {
			Date data = addMonths(contract.getDate(), i);
			double updateQuota = firstQuota + ops.interest(firstQuota, i);
			double finalQuota = updateQuota + ops.paymentFee(updateQuota);
			contract.addInstallments(new Installment(data, finalQuota));
		}
	}
	
	public Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
