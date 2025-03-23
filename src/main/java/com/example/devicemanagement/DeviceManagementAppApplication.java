package com.example.devicemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DeviceManagementAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviceManagementAppApplication.class, args);
    }

    @RestController
    public class DeviceController {

        @GetMapping("/api/devices/status")
        public String getDeviceStatus() {
            return "Device Status: Online"; // Placeholder
        }
    }
}