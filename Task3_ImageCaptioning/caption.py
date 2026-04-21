from transformers import pipeline
from PIL import Image

# Load pretrained image captioning model
captioner = pipeline("image-to-text", model="nlpconnect/vit-gpt2-image-captioning")

# Load image (make sure image is in same folder)
image = Image.open("image.jpg")

# Generate caption
result = captioner(image)

# Print result
print("Generated Caption:")
print(result[0]['generated_text'])
