package group40.whatrentsellerapp.service.mapping;

import group40.whatrentsellerapp.domain.Category;
import group40.whatrentsellerapp.domain.Product;
import group40.whatrentsellerapp.domain.Seller;
import group40.whatrentsellerapp.dto.productDto.ProductRequestDto;
import group40.whatrentsellerapp.dto.productDto.ProductResponseDto;
import group40.whatrentsellerapp.repository.ICategoryRepository;
import group40.whatrentsellerapp.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductConverter {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private ISellerRepository sellerRepository;

    public Product convertFromDto(ProductRequestDto dto) {
        Product product = new Product();

        if (dto.getProductName() != null) {
            product.setName(dto.getProductName());
        }
        if (dto.getProductDescription() != null) {
            product.setDescription(dto.getProductDescription());
        }

        if (dto.getProductPrice() != null) {
            product.setPrice(dto.getProductPrice());
        }

        if (dto.getProductQuantity() != null) {
            product.setQuantity(dto.getProductQuantity());
        }

        if (dto.getIsOnStock() != null) {
            product.setIsOnStock(dto.getIsOnStock());
        }
        if (dto.getSellerId() !=null) {
            Optional<Seller> sellerOpt = sellerRepository.findById(dto.getSellerId());
            sellerOpt.ifPresent(product::setSeller);
        }
        if (dto.getProductCategoryId() !=null) {
            Optional<Category> categoryOpt = categoryRepository.findById(dto.getProductCategoryId());
            categoryOpt.ifPresent(product::setCategory);
        }
        return product;
    }

    public ProductResponseDto convertToDto(Product product) {

        ProductResponseDto dto = new ProductResponseDto();
        dto.setProductId(product.getId());

        if (product.getName() != null) {
            dto.setProductName(product.getName());
        }
        if (product.getDescription() != null) {
            dto.setProductDescription(product.getDescription());
        }
        if (product.getPrice() != null) {
            dto.setProductPrice(product.getPrice());
        }
        if (product.getQuantity() != null) {
            dto.setProductQuantity(product.getQuantity());
        }
        if (product.getCategory() != null) {
            dto.setProductCategory(product.getCategory());
        }
        if (product.getIsOnStock() != null) {
            dto.setIsOnStock(product.getIsOnStock());
        }
        if (product.getSeller() != null && product.getSeller().getId() != null) {
            dto.setSellerId(product.getSeller().getId());
            dto.setSellerBusinessName(product.getSeller().getBusinessName());
        }
        return dto;
    }
}