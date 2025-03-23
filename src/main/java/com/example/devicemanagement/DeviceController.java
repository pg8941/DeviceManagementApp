package com.example.devicemanagement;

import com.example.devicemanagement.model.Device;
import com.example.devicemanagement.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/api/devices")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/api/devices/{id}")
    public Device getDeviceById(@PathVariable String id) {
        return deviceService.getDeviceById(id);
    }

    @PutMapping("/api/devices/{id}/status")
    public void updateDeviceStatus(@PathVariable String id, @RequestBody Map<String, String> payload) {
        String status = payload.get("status");
        if (status != null) {
            deviceService.updateDeviceStatus(id, status);
        }
    }
}