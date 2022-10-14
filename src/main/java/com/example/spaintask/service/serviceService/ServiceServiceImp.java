//package com.example.spaintask.service.serviceService;
//
//import com.example.spaintask.models.serviceModel.Service;
//import com.example.spaintask.models.userModel.User;
//import com.example.spaintask.repository.ServiceRepository;
//import org.joda.time.DateTime;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//
//
//@org.springframework.stereotype.Service
//public  class ServiceServiceImp implements ServiceService{
//
//    @Autowired
//    ServiceRepository serviceRepository;
//
////    @Override
////    public Service addService(Service newService) {
////        newService.setDate(DateTime.now().toDate());
////        return serviceRepository.save(newService);
////    }
//
//    @Override
//    public Service addService(User serviceOfUser) {
//        Service service = (Service) serviceOfUser.getService();
//        System.out.println(service.getId());
//        System.out.println(service.getVendor());
//        System.out.println(service.getDate());
//        System.out.println(service.getStatus());
//        System.out.println("**********************");
//        service.setId(((Service) serviceOfUser.getService()).getId());
//        System.out.println(service.getId());
//        service.setVendor(((Service) serviceOfUser.getService()).getVendor());
//        System.out.println(service.getVendor());
//      //  service.setDate(DateTime.now().toDate());
//        System.out.println(service.getDate());
//        service.setStatus(((Service) serviceOfUser.getService()).getStatus());
//        System.out.println(service.getStatus());
//
//        return serviceRepository.save(service);
//    }
//
//
//}
