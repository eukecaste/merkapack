package com.merkapack.erp.gwt.client.common.css;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {

	@Source("mkpk.css")
	@CssResource.NotStrict
	CSS css();
	
	@Source("images/mkpk-logo.png")
	ImageResource mkpkLogo();

	@Source("images/mkpk-manufacturing.png")
	ImageResource mkpkManufacturing();

	@Source("images/mkpk-planning.png")
	ImageResource mkpkPlanning();

	@Source("images/mkpk-stats.png")
	ImageResource mkpkStats();
	
	@Source("images/mkpk-icon-bullet.png")
	ImageResource mkpkIconBullet();

	@Source("images/mkpk-input-error.png")
	ImageResource mkpkInputError();

	@Source("images/mkpk-input-calc.png")
	ImageResource mkpkInputCalc();

	@Source("images/mkpk-icon-menu.png")
	ImageResource mkpkIconMenu();

	@Source("images/mkpk-icon-cancel.png")
	ImageResource mkpkIconCancel();

	@Source("images/mkpk-icon-accept.png")
	ImageResource mkpkIconAccept();

	@Source("images/mkpk-icon-delete.png")
	ImageResource mkpkIconDelete();

	@Source("images/mkpk-icon-plus.png")
	ImageResource mkpkIconPlus();
	
	@Source("images/mkpk-menu.png")
	ImageResource mkpkMenu();

	@Source("images/mkpk-close.png")
	ImageResource mkpkClose();

	@Source("images/mkpk-cd-close.gif")
	ImageResource mkpkCDClose();
	
	@Source("images/mkpk-cd-header.png")
	ImageResource mkpkCDHeader();
	
	@Source("images/mkpk-cd-header-back.png")
	ImageResource mkpkCDHeaderBack();
	
}

