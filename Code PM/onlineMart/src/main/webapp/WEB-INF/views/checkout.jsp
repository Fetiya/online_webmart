<%-- 
    Document   : checkout
    Created on : Jan 3, 2015, 2:32:54 PM
    Author     : Fetiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <h2 class="title text-center">Check Out</h2>
                    <p class="title ">New User check Out Options</p>

                    <p class="title ">
                        <a class="title" style="color:#fe980f;font-size: 13px; text-decoration: underline" href= "#">Register Account</a>
                        <a class="title" style="color:#fe980f;font-size: 13px; text-decoration: underline" href= "#"> Guest Checkout</a>
                    </p>
                                                                    
                                                                        <input type="text" placeholder="First Name *">
									<input type="text" placeholder="Middle Name">
									<input type="text" placeholder="Last Name *">
									<input type="text" placeholder="Email*">
                                                                        <input type="text" placeholder="Address 1 *">
									<input type="text" placeholder="Address 2">
                                                                        <input type="text" placeholder="Zip / Postal Code *">
                                                                        <select>
										<option>-- Country --</option>
										<option>United States</option>
										<option>Bangladesh</option>
										<option>UK</option>
										<option>India</option>
										<option>Pakistan</option>
										<option>Ucrane</option>
										<option>Canada</option>
										<option>Dubai</option>
									</select>
                                                                        <select>
										<option>-- State / Province / Region --</option>
										<option>United States</option>
										<option>Bangladesh</option>
										<option>UK</option>
										<option>India</option>
										<option>Pakistan</option>
										<option>Ucrane</option>
										<option>Canada</option>
										<option>Dubai</option>
									</select>
                                                                        <input type="text" name="Phone" placeholder="Phone *">
                                                                        <input type="text" name="cardNumber" placeholder="Card Number">
                                                                        <input type="text" name="securityNumber" placeholder="Card Security Number">
                                                                         <input type="text" name="totalAmount" >
						                       <button class="btn btn-primary" type="submit">Place Order </button>
						                                                                           	
                                                                       </form>
=======
                                                                       </form>-->
                                                            
                                                            <form:form commandName="payment" modelAttribute="payment" action="cardValidation" method="post">
                                                                <table>
                                                                    <tr class="form-group col-md-12">
                                                                 <td class="td-label"><form:label path="name"  class="td-label">Full Name:</form:label></td>
                                                                 <td class="td-input"><form:input path="name"  placeholder="First Name and Last Name" /></td>
                                                                 <td><form:errors path="name" cssClass="error" /></td>
                                                                </tr>
                                                                
                                                                 <tr class="form-group col-md-12">
                                                                 <td class="td-label"><form:label path="cardType"  class="td-label">Card Type:</form:label></td>
                                                                 <td class="td-input">
                                                                 <form:select path="cardType"  placeholder="Card Type *" >
                                                                         <form:option value="visa">Visa</form:option>
                                                                         <form:option value="masterCard">Master Card</form:option>
                                                                     </form:select>
                                                                     </td>
                                                                 <td><form:errors path="cardType" cssClass="error" /></td>
                                                                </tr>
<!--                                                                <select  name="cardType" placeholder="Card Type *">
                                                                                <option>Visa </option>
										<option>Master Card</option>
                                                                        </select>
                                                                -->
                                                                 <tr class="form-group col-md-12">
                                                                <td class="td-label"><form:label path="name"  class="td-label">Card Number:</form:label></td>
                                                               <td class="td-input"><form:input path="cardNumber"  placeholder="Card Number *"/></td>
                                                                <td><form:errors path="cardNumber" cssClass="error" /></td>
                                                                 </tr>
                                                                 <tr class="form-group col-md-12">
                                                                <td class="td-label"><form:label path="name"  class="td-label">Card Security Number:</form:label></td>
                                                                <td class="td-input"><form:input path="securityNumber" placeholder="Card Security Number *"/></td>
                                                                <td><form:errors path="securityNumber" cssClass="error" /></td>
                                                                 </tr>
                                                                 
                                                                 <tr class="form-group col-md-12">
                                                                <td class="td-label"><form:label path="name"  class="td-label">Expiry Date : </form:label></td>
                                                                <td class="td-input"><form:input path="expiryDate"   placeholder="Expiry Date *"/></td>
                                                                <td><form:errors path="expiryDate" cssClass="error" /></td>
                                                                       </tr>
                                                                       <tr>
                                                                       <td class="td-input"><form:input path="expiryDate"   placeholder="total amount"/></td>
                                                                       </tr>
                                                                 <tr class="form-group col-md-12">
                                                                     <td class="td-input"> 
                                                                 <button class="btn btn-primary" type="submit">Place Order </button>
                                                                     </td>
                                                                 </tr>
                                                                </table> 
                                                            </form:form>

							</div>
                                                       	</div>
					</div>
<!--					<div class="col-sm-4">
						<div class="order-message">
							<p>Shipping address</p>
							<textarea name="message"  placeholder="Notes about your order, Special Notes for Delivery" rows="16"></textarea>
							<label><input type="checkbox"> Shipping to bill address</label>
						</div>	
					</div>-->
                                        
				</div>
			</div>
			<div class="review-payment">
				<h2>Review & Payment</h2>
			</div>

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="cart_product">
								<a href=""><img src="images/cart/one.png" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">Colorblock Scuba</a></h4>
								<p>Web ID: 1089772</p>
							</td>
							<td class="cart_price">
								<p>$59</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$59</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>

						<tr>
							<td class="cart_product">
								<a href=""><img src="images/cart/two.png" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">Colorblock Scuba</a></h4>
								<p>Web ID: 1089772</p>
							</td>
							<td class="cart_price">
								<p>$59</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$59</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>
						<tr>
							<td class="cart_product">
								<a href=""><img src="images/cart/three.png" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">Colorblock Scuba</a></h4>
								<p>Web ID: 1089772</p>
							</td>
							<td class="cart_price">
								<p>$59</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$59</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>Cart Sub Total</td>
										<td>$59</td>
									</tr>
									<tr>
										<td>Exo Tax</td>
										<td>$2</td>
									</tr>
									<tr class="shipping-cost">
										<td>Shipping Cost</td>
										<td>Free</td>										
									</tr>
									<tr>
										<td>Total</td>
										<td><span>$61</span></td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="payment-options">
					<span>
						<label><input type="checkbox"> Direct Bank Transfer</label>
					</span>
					<span>
						<label><input type="checkbox"> Check Payment</label>
					</span>
					<span>
						<label><input type="checkbox"> Paypal</label>
					</span>
				</div>
		</div>
	</section> <!--/#cart_items-->

