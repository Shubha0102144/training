package main

import "testing"

func Test_laundry_initialize(t *testing.T) {
	l := laundryshop{}

	if len(l.staffDetials) != 0 {
		t.Error("staff detials is not empty")
	}

	if len(l.machineDetials) != 0 {
		t.Error("machine details is not empty")
	}

	if len(l.customerDetails) != 0 {
		t.Error("csutomer details is not empty")
	}

	if service == nil {
		t.Error("service map does not exist")

	}

	if service["wash"] == 0 {
		t.Error("price not added to wash service")
	}

	if service["iron"] == 0 {
		t.Error("price not added to iron service")
	}

	if service["dry_clean"] == 0 {
		t.Error("price not added to dry-clean service")

	}

}

func Test_add_staff(t *testing.T) {

	l := laundryshop{}

	l.addStaff(2, "abc")

	if len(l.staffDetials) != 1 {
		t.Error("staff not added")
	}
	if l.staffDetials[0].id != 2 {
		t.Error("staff id not added")
	}
	if l.staffDetials[0].name != "abc" {
		t.Error("staff name not added")
	}
}

func Test_add_machine(t *testing.T) {
	l := laundryshop{}
	s := l.addStaff(1, "abc")
	s.addMachine(&l, 1, 7)

	if len(l.machineDetials) != 1 {
		t.Error("machine not added")
	}

	if l.machineDetials[0].id != 1 {
		t.Error("machine id not added")
	}

	if l.machineDetials[0].capacity != 7 {
		t.Error("machine capacity not added")
	}
}

func Test_staff_add_customer(t *testing.T) {
	l := laundryshop{}
	s := l.addStaff(1, "abc")
	s.addMachine(&l, 1, 7)

	s.addCustomer(&l, 1, "shubha")

	if l.customerDetails[0].id != 1 {
		t.Error("customer not added")
	}

	if l.customerDetails[0].name != "shubha" {
		t.Error("customer name not added")
	}

}

func Test_staff_create_order(t *testing.T) {
	l := laundryshop{}
	s := l.addStaff(1, "abc")
	s.addMachine(&l, 1, 7)
	s.addCustomer(&l, 1, "shubha")

	s.createOrder(&l, 1, "wash", 10)

	if l.orderDetials[0].id != 1 {
		t.Error("order not added")
	}

	if l.orderDetials[0].servicetype != "wash" {
		t.Error("service not added")
	}

	if l.orderDetials[0].itemcount != 10 {
		t.Error("total items not added")
	}

}

func Test_validate_id(t *testing.T) {

	l := laundryshop{}
	s := l.addStaff(1, "abc")
	s.addMachine(&l, 1, 7)
	s.addCustomer(&l, 1, "shubha")

	s.createOrder(&l, 1, "wash", 10)
	if l.validateId(1) != nil {
		t.Error("order id not added")

	}

}

func Test_validate_status(t *testing.T) {

	l := laundryshop{}
	s := l.addStaff(1, "abc")
	s.addMachine(&l, 1, 7)
	s.addCustomer(&l, 1, "shubha")

	s.createOrder(&l, 1, "wash", 10)

	if validateStatus("received") != nil {
		t.Error("invalid status")
	}

}

func Test_findById(t *testing.T) {

	l := laundryshop{}
	s := l.addStaff(1, "abc")
	s.addMachine(&l, 1, 7)
	s.addCustomer(&l, 1, "shubha")

	s.createOrder(&l, 1, "wash", 10)
	if s.findOrderbyId(&l, 1) != 1 {
		t.Error("invalid status")
	}

}

/*
func Test_list_order(t *testing.T){
	l := laundryshop{}
	s := l.addStaff(1, "abc")
	s.addMachine(&l, 1, 7)
	s.addCustomer(&l, 1, "shubha")

	s.createOrder(&l, 1, "wash", 10)
	actual:=[]string {"1","recieved"}
	if(l.listOrdersByStatus(recieved).toString()!=actual){
      t.Error("invalid status")
	}

}
*/
