import { Box, Text } from "@chakra-ui/react";
function Footer() {
  return (
    <Box bg="black" color="white" py={4} textAlign="center" mt={10}>
      <Text>© {new Date().getFullYear()} Game Store. All Rights Reserved.</Text>
    </Box>
  );
}
export default Footer;