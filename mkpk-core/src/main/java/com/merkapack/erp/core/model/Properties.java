package com.merkapack.erp.core.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.merkapack.erp.core.model.Filter.Property;

public interface Properties {
	
	public interface AuditProperties {
		Property<String> getCreationUserProperty();
		Property<Timestamp> getCreationDateProperty();
		Property<String> getModificationUserProperty();
		Property<Timestamp> getModificationDateProperty();
	}

	public interface ProductProperties extends AuditProperties {
		Property<Integer> getIdProperty();
		Property<Integer> getDomainProperty();
		Property<String> getCodeProperty();
		Property<String> getNameProperty();
		Property<Integer> getMaterialUpIdProperty();
		Property<String> getMaterialUpNameProperty();
		Property<Integer> getMaterialDownIdProperty();
		Property<String> getMaterialDownNameProperty();
		Property<Double> getWidthProperty();
		Property<Double> getLengthProperty();
		Property<Double> getBoxUnitsProperty();
		Property<String> getMoldProperty();
	}

	public interface RollProperties extends AuditProperties {
		Property<Integer> getIdProperty();
		Property<Integer> getDomainProperty();
		Property<String> getNameProperty();
		Property<Double> getWidthProperty();
		Property<Double> getLengthProperty();
		Property<Integer> getMaterialIdProperty();
		Property<String> getMaterialNameProperty();
	}

	public interface ClientProperties extends AuditProperties {
		Property<Integer> getIdProperty();
		Property<Integer> getDomainProperty();
		Property<String> getNameProperty();
	}
	
	public interface PlanningProperties extends AuditProperties {
		Property<Integer> getIdProperty();
		Property<Integer> getDomainProperty();
		Property<Date> getDateProperty();
		Property<Integer> getOrderProperty();
		Property<Double> getAmountProperty();
		Property<Integer> getMachineIdProperty();
		Property<String> getMachineNameProperty();
		Property<Integer> getProductIdProperty();
		Property<String> getProductNameProperty();
		Property<Double> getWidthProperty();
		Property<Double> getLengthProperty();
		Property<Integer> getMaterialUpIdProperty();
		Property<String> getMaterialUpNameProperty();
		Property<Integer> getRollUpIdProperty();
		Property<String> getRollUpNameProperty();
		Property<Double> getRollUpWidthProperty();
		Property<Double> getRollUpLengthProperty();
		Property<Integer> getMaterialDownIdProperty();
		Property<String> getMaterialDownNameProperty();
		Property<Integer> getRollDownIdProperty();
		Property<String> getRollDownNameProperty();
		Property<Double> getRollDownWidthProperty();
		Property<Double> getRollDownLengthProperty();
		Property<Integer> getBlowUnitsProperty();
		Property<Double> getMetersProperty();
		Property<Double> getBlowsProperty();
		Property<Double> getBlowsMinuteProperty();
		Property<Double> getMinuteProperty();
	}

}