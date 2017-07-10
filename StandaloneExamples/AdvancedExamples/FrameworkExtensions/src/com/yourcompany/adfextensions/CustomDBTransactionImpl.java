package com.yourcompany.adfextensions;

import oracle.jbo.server.DBTransactionImpl2;

/**
 * Custom ADF Framework Extension Class for ADF Transaction
 * 
 * Works in tandem with the CustomDatabaseTransactionFactory
 * implementation that returns instances of this subclass
 * of DBTransactionImpl2 instead of the default one.
 * @author you
 */
public class CustomDBTransactionImpl extends DBTransactionImpl2 {
  // Add your custom code here or use the
  // Source | Override Methods... dialog to override
  // methods in the base class.
}
