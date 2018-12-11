package com.merkapack.erp.gwt.shared;

import java.io.Serializable;

import com.merkapack.erp.core.model.Planning;
import com.merkapack.watson.util.MkpkMathUtils;

public enum PlanningCalculatorStrategy implements Serializable {
	AMOUNT_CHANGED {
		public void specialCalculate(PlanningCalculatorParams params,Planning pl) {
			pl.setMeters(MkpkMathUtils.round((pl.getLength() * pl.getAmount()) / (1000 * pl.getBlowUnits())));
			pl.setBlows(MkpkMathUtils.round(pl.getAmount() / pl.getBlowUnits()));
			pl.setMinutes(MkpkMathUtils.round(pl.getBlows() / pl.getBlowsMinute()));
		}
	},
	METERS_CHANGED {
		public void specialCalculate(PlanningCalculatorParams params,Planning pl) {
			double amount = MkpkMathUtils.round((pl.getMeters() * pl.getBlowUnits() * 1000) / pl.getLength());
			pl.setBlows(MkpkMathUtils.floor(amount / pl.getBlowUnits(), 0));
			pl.setAmount( MkpkMathUtils.round(pl.getBlows() * pl.getBlowUnits()) );
			AMOUNT_CHANGED.specialCalculate(params,pl);
		}
	},
	TIME_CHANGED {
		public void specialCalculate(PlanningCalculatorParams params,Planning pl) {
			pl.setBlows( MkpkMathUtils.floor(pl.getBlowsMinute() * pl.getMinutes(),0) );
			pl.setAmount(MkpkMathUtils.round(pl.getBlows() * pl.getBlowUnits()));
			AMOUNT_CHANGED.specialCalculate(params,pl);
		}
	};
	
	public abstract void specialCalculate(PlanningCalculatorParams params,Planning planning);
	
	public void calculate(PlanningCalculatorParams params,Planning planning) {
		if (basicCalculate(params,planning)) {
			specialCalculate(params,planning);
		}
	}

	protected boolean basicCalculate(PlanningCalculatorParams params,Planning planning) {
		if (planning.getProduct() == null) {
			planning.initialize();
			return false;
		}
		planning.setWidth(planning.getProduct().getWidth());
		planning.setLength(planning.getProduct().getLength());

		if (planning.getMaterial() == null) {
			if (planning.getProduct().getMaterial() == null) {
				planning.initialize();
				return false;
			}
			planning.setMaterial(planning.getProduct().getMaterial());
		}
		if (planning.getRoll() != null) {
			planning.setRollWidth(planning.getRoll().getWidth());
			planning.setRollLength(planning.getRoll().getLength());
			planning.setBlowUnits((int) MkpkMathUtils.round(planning.getRollWidth() / planning.getWidth(), 0));
		}
		return !MkpkMathUtils.isZero(planning.getBlowUnits());
	}

}
