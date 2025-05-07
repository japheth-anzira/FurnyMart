package com.japheth.furnymart.navigation

const val ROUT_HOME ="home"
const val ROUT_ABOUT ="about"
const val ROUT_CONTACT ="contact"
const val ROUT_SPLASH ="splash"
const val ROUT_BEDS ="beds"
const val ROUT_CART ="cart"
const val ROUT_CHAIRS ="chairs"
const val ROUT_SOFAS ="sofa"
const val ROUT_CHECKOUT ="checkout"
const val ROUT_TABLES ="tables"
const val ROUT_PROFILE ="profile"
const val ROUT_ONBOARDSCREEN="onboard"
const val ROUT_ONBOARDSCREEN2="onboard2"
const val ROUT_ORDERCONFIRMATION="orderconfirmation"

//Products

const val ROUT_ADD_PRODUCT = "add_product"
const val ROUT_PRODUCT_LIST = "product_list"
const val ROUT_EDIT_PRODUCT = "edit_product/{productId}"
// ✅ Helper function for navigation
fun editProductRoute(productId: Int) = "edit_product/$productId"

//Authentication
const val ROUT_REGISTER = "Register"
const val ROUT_LOGIN = "Login"