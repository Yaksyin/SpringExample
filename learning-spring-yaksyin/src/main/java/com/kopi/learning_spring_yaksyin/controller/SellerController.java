package com.kopi.learning_spring_yaksyin.controller;

import com.kopi.learning_spring_yaksyin.entity.SellerEntitiy;
import com.kopi.learning_spring_yaksyin.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;

    // Menampilkan daftar seller
    @GetMapping
    public ResponseEntity<List<SellerEntitiy>> listgetList(){
        List<SellerEntitiy> userEntitiy = sellerRepository.findAll();
        return new ResponseEntity<>(userEntitiy, HttpStatus.OK);
    }

    // Menambahkan seller baru
    @PostMapping("/")
    public String addSeller(@RequestBody SellerEntitiy sellerEntitiy) {
        sellerEntitiy.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        sellerRepository.save(sellerEntitiy);
        return "redirect:/sellers/";
    }

    // Menggunakan @RequestBody untuk menerima data JSON
    @PostMapping
    public ResponseEntity<?> Create(@RequestBody SellerEntitiy sellerEntitiy) {
        sellerRepository.save(sellerEntitiy);
        return ResponseEntity.ok(sellerEntitiy);
    }
    // Menampilkan detail seller berdasarkan ID
    @GetMapping("/{id}")
    public String getSellerId(@PathVariable("id") String id, Model model) {
        Optional<SellerEntitiy> seller = sellerRepository.findById(id);
        if (seller.isPresent()) {
            model.addAttribute("seller", seller.get());
            return "seller-detail"; // View untuk menampilkan detail seller
        } else {
            return "404"; // Halaman jika data tidak ditemukan
        }
    }

    // Menghapus seller berdasarkan ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>DeleteCoffeId(@PathVariable("id") String id ,SellerEntitiy sellerEntitiy) {
            sellerRepository.deleteById(id);
        return ResponseEntity.ok(sellerEntitiy);// Redirect ke halaman daftar seller setelah menghapus
    }
    // Mengedit seller berdasarkan ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeller(@PathVariable("id") String id, @RequestBody SellerEntitiy sellerEntitiy) {
        // Mencari seller berdasarkan ID
        Optional<SellerEntitiy> existingSeller = sellerRepository.findById(id);
        if (existingSeller.isPresent()) {
            // Mengambil data lama dan memperbarui dengan data baru
            SellerEntitiy updatedSeller = existingSeller.get();
            updatedSeller.setCoffeType(sellerEntitiy.getCoffeType());
            updatedSeller.setSellerName(sellerEntitiy.getSellerName());
            updatedSeller.setSellerId(sellerEntitiy.getSellerId());
            updatedSeller.setProductName(sellerEntitiy.getProductName());
            updatedSeller.setProductId(sellerEntitiy.getProductId());
            updatedSeller.setCreatedBy(sellerEntitiy.getCreatedBy());
            updatedSeller.setCreatedAt(new Timestamp(System.currentTimeMillis())); // Perbarui waktu
            sellerRepository.save(updatedSeller); // Simpan ke database
            return ResponseEntity.ok(sellerEntitiy);
        } else {
            // Jika seller tidak ditemukan, kembalikan status NOT FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seller with ID " + id + " not found.");
        }
    }

}
