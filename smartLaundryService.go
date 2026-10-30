package main

import (
	"fmt"
	"strings"
)

type machine struct {
	id       int
	capacity int
}

type staff struct {
	id   int
	name string
}

func (s *staff) addMachine(l *laundryshop, id, capacity int) machine {
	m := machine{id, capacity}
	l.addMachine(id, capacity)
	return m

}

type status string

var (
	recieved  status = "received"
	washing   status = "washing"
	ready     status = "ready"
	collected status = "collected"
)

type customer struct {
	id   int
	name string
}

type order struct {
	id            int
	servicetype   string
	itemcount     int
	statusDetails status
}

var service = map[string]int{"wash": 10, "iron": 20, "dry_clean": 30}

type laundryshop struct {
	machineDetials  []machine
	staffDetials    []staff
	customerDetails []customer
	orderDetials    []order
	serviceDetials  []map[string]int
	statusDetails   []status
}

func (l *laundryshop) addStaff(id int, name string) staff {
	s := staff{id, name}
	l.staffDetials = append(l.staffDetials, s)
	fmt.Println(l.staffDetials)
	return s

}

func (l *laundryshop) addMachine(id, capacity int) machine {
	m := machine{id, capacity}
	l.machineDetials = append(l.machineDetials, m)
	return m
}

func (s *staff) addCustomer(l *laundryshop, id int, name string) customer {
	c := customer{id, name}
	l.customerDetails = append(l.customerDetails, c)
	return c
}

func (s *staff) createOrder(l *laundryshop, id int, servicetype string, itemcount int) order {
	o := order{id, servicetype, itemcount, recieved} //l.statusDetails[0]}
	l.orderDetials = append(l.orderDetials, o)
	return o
}

func (l *laundryshop) validateId(id int) error {
	for i := range l.orderDetials {
		if l.orderDetials[i].id == id {
			return nil
		}
	}
	return fmt.Errorf("id is not registered")
}

func (s *staff) findOrderbyId(l *laundryshop, id int) int {

	for _, o := range l.orderDetials {
		if l.validateId(id) == nil {
			if o.id == id {
				return o.id // return o
			}
		}
	}
	return -1 // return o{}

}

func (s *staff) listallorders(l *laundryshop) order {
	for _, o := range l.orderDetials {
		return o
	}

	return order{}
}

func validateStatus(requestedStatus string) error {
	if strings.ToLower(requestedStatus) == "received" || strings.ToLower(requestedStatus) == "washing" || strings.ToLower(requestedStatus) == "ready" || strings.ToLower(requestedStatus) == "collected" {
		return nil
	}
	return fmt.Errorf("invalid status")
}

func (l *laundryshop) listOrdersByStatus(status status) (int, status) {
	for _, o := range l.orderDetials {

		if o.statusDetails == status {
			return o.id, o.statusDetails

		}
	}
	return 0, ""

}

func (s *staff) updateOrderStatus(l *laundryshop, id int) error {

	for _, o := range l.orderDetials {
		if l.validateId(id) == nil {
			if o.id == id {
				if len(o.statusDetails) == 0 {
					o.statusDetails = "received"
				} else if o.statusDetails == "received" {
					o.statusDetails = "washing"
				} else if o.statusDetails == "washing" {
					o.statusDetails = "ready"
				} else {
					o.statusDetails = "collected"
				}
			} else {
				return fmt.Errorf("invalid id")
			}
		}
	}
	return nil

}
