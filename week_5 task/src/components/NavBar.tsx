import { HStack, Image, Text, Input, InputGroup, InputRightElement, IconButton, Spacer } from "@chakra-ui/react";
import { FaSearch, FaHeart, FaShoppingCart, FaUser} from "react-icons/fa";
import logo from '../assets/pngtree-games-store-with-wired-controller-kids-store-png-image_4652466.png';
import DarkSwitch from "./DarkSwitch";
function NavBar() {
  return (
    <HStack bg="black"  padding="10px 20px" spacing={4}>
      <HStack>
        <Image src={logo} boxSize="50px" />
        <Text fontSize="2xl" color="lawngreen" fontFamily='cursive' fontWeight="bold">Gamer's Studio</Text>
      </HStack>
      <Spacer />
      <HStack spacing={6} color="white" fontSize="md" fontWeight="bold" fontFamily='inherit'>
        <Text cursor="pointer">Playstation</Text>
        <Text cursor="pointer">Xbox</Text>
        <Text cursor="pointer">Nintendo</Text>
        <Text cursor="pointer">Digital</Text>
        <Text cursor="pointer">Accessories</Text>
        <Text cursor="pointer">Merchandise</Text>
        <Text cursor="pointer">Pre-order</Text>
      </HStack>
      <Spacer />
      <HStack spacing={4}>
        <IconButton aria-label="Wishlist" icon={<FaHeart />} size="sm" variant="ghost" />
        <IconButton aria-label="Cart" icon={<FaShoppingCart />} size="sm" variant="ghost" />
        <IconButton aria-label="Profile" icon={<FaUser />} size="sm" variant="ghost" />
        <DarkSwitch />
      </HStack>
    </HStack>
  );
}
export default NavBar;