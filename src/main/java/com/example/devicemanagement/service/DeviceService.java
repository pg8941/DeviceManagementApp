package com.example.devicemanagement.service;

import com.example.devicemanagement.model.Device;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    private List<Device> devices = new ArrayList<>();

    public DeviceService() {
        // Initialize some devices
        devices.add(new Device("1", "USB Drive", "Online"));
        devices.add(new Device("2", "Printer", "Offline"));
    }

    public List<Device> getAllDevices() {
        return devices;
    }

    public Device getDeviceById(String id) {
        return devices.stream()
                .filter(device -> device.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void updateDeviceStatus(String id, String status) {
        Device device = getDeviceById(id);
        if (device != null) {
            device.setStatus(status);
        }
    }
}